public class Solution
{

  int bitSize (long num)
  {
    int n = 0;
    while (num > 0)
    {
      ++n;
      num >>= 1;
    }
    return n;
  }

  long divide (long dividend, long divisor)
  {
    if (divisor == 0)
      throw new RuntimeException();
    if (dividend < divisor)
      return 0;
    int n1 = bitSize(dividend), n2 = bitSize(divisor);
    long quotient = 0;
    for (int i = n1 - n2; i >= 0; --i)
    {
      if (divisor << i <= dividend)
      {
        quotient |= 1L << i;
        dividend -= divisor << i;
      }
    }
    return quotient;
  }

  public int divide (int dividend, int divisor)
  {
    long quotient = divide(Math.abs((long)dividend), Math.abs((long)divisor));
    if (((dividend ^ divisor) & 1 << 31) != 0)
      quotient = -quotient;
    return (int)quotient;
  }

}
