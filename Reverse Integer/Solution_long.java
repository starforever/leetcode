public class Solution
{

  long reverse (long x)
  {
    if (x < 0)
      return -reverse(-x);
    long y = 0;
    while (x > 0)
    {
      y = y * 10 + x % 10;
      x /= 10;
    }
    return y;
  }

  public int reverse (int x)
  {
    long y = reverse((long)x);
    if (y < Integer.MIN_VALUE || y > Integer.MAX_VALUE)
      throw new RuntimeException();
    return (int)y;
  }

}
