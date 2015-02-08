public class Solution
{

  int bitSize (int num)
  {
    int n = 31;
    while (n > 0 && (num & 1 << n) == 0)
      --n;
    return n;
  }

  int dividePositive (int dividend, int divisor)
  {
    int n1 = bitSize(dividend), n2 = bitSize(divisor);
    int quotient = 0;
    for (int i = n1 - n2; i >= 0; --i)
    {
      if (dividend - (divisor << i) >= 0)
      {
        quotient |= 1 << i;
        dividend -= divisor << i;
      }
    }
    return quotient;
  }

  public int divide (int dividend, int divisor)
  {
    if (divisor == 0)
      throw new RuntimeException();
    int quotient = dividePositive(Math.abs(dividend), Math.abs(divisor));
    if (((dividend ^ divisor) & 1 << 31) != 0)
      quotient = -quotient;
    return quotient;
  }

}
