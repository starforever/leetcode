public class Solution
{
  public String fractionToDecimal (int numerator, int denominator)
  {
    if (denominator == 0)
      throw new ArithmeticException();
    boolean isNegative = false;
    if (numerator < 0)
    {
      numerator = -numerator;
      isNegative = !isNegative;
    }
    if (denominator < 0)
    {
      denominator = -denominator;
      isNegative = !isNegative;
    }
    int integral = numerator / denominator;
    int remainder = numerator % denominator;
    HashMap<Integer, Integer> index = new HashMap<Integer, Integer>();
    ArrayList<Integer> frac = new ArrayList<Integer>();
    while (remainder > 0 && !index.containsKey(remainder))
    {
      index.put(remainder, frac.size());
      remainder *= 10;
      frac.add(remainder / denominator);
      remainder %= denominator;
    }
    StringBuilder sb = new StringBuilder();
    if (isNegative)
      sb.append("-");
    sb.append(integral);
    if (frac.size() > 0)
    {
      sb.append(".");
      if (remainder == 0)
      {
        for (int i = 0; i < frac.size(); ++i)
          sb.append(frac.get(i));
      }
      else
      {
        int split = index.get(remainder);
        for (int i = 0; i < split; ++i)
          sb.append(frac.get(i));
        sb.append("(");
        for (int i = split; i < frac.size(); ++i)
          sb.append(frac.get(i));
        sb.append(")");
      }
    }
    return sb.toString();
  }
}
