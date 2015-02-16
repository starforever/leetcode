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
    int[] index = new int[denominator];
    for (int i = 0; i < denominator; ++i)
      index[i] = -1;
    int[] frac = new int[denominator];
    int numFrac = 0;
    while (remainder > 0 && index[remainder] == -1)
    {
      index[remainder] = numFrac;
      remainder *= 10;
      frac[numFrac++] = remainder / denominator;
      remainder %= denominator;
    }
    StringBuilder sb = new StringBuilder();
    if (isNegative)
      sb.append("-");
    sb.append(integral);
    if (numFrac > 0)
    {
      sb.append(".");
      if (remainder == 0)
      {
        for (int i = 0; i < numFrac; ++i)
          sb.append(frac[i]);
      }
      else
      {
        int split = index[remainder];
        for (int i = 0; i < split; ++i)
          sb.append(frac[i]);
        sb.append("(");
        for (int i = split; i < numFrac; ++i)
          sb.append(frac[i]);
        sb.append(")");
      }
    }
    return sb.toString();
  }
}
