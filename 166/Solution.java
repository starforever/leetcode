public class Solution
{
  private String fractionToDecimal (long numerator, long denominator)
  {
    boolean isNegative = false;
    if (numerator < 0)
    {
      isNegative = !isNegative;
      numerator = -numerator;
    }
    if (denominator < 0)
    {
      isNegative = !isNegative;
      denominator = -denominator;
    }
    long integral = numerator / denominator;
    long remainder = numerator % denominator;
    HashMap<Integer, Integer> index = new HashMap<Integer, Integer>();
    StringBuilder frac = new StringBuilder();
    while (remainder > 0 && !index.containsKey((int)remainder))
    {
      index.put((int)remainder, frac.length());
      remainder *= 10;
      frac.append(remainder / denominator);
      remainder %= denominator;
    }
    StringBuilder sb = new StringBuilder();
    if (isNegative)
      sb.append("-");
    sb.append(integral);
    if (frac.length() > 0)
    {
      sb.append(".");
      if (remainder == 0)
      {
        sb.append(frac);
      }
      else
      {
        int split = index.get((int)remainder);
        sb.append(frac.substring(0, split));
        sb.append("(");
        sb.append(frac.substring(split));
        sb.append(")");
      }
    }
    return sb.toString();
  }

  public String fractionToDecimal (int numerator, int denominator)
  {
    if (denominator == 0)
      throw new ArithmeticException();
    if (numerator == 0)
      return "0";
    return fractionToDecimal((long)numerator, (long)denominator);
  }
}
