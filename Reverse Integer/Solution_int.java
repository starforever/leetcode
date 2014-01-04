public class Solution
{
  public int reverse (int x)
  {
    if (x < 0)
      return -reverse(-x);
    int y = 0;
    while (x > 0)
    {
      if (y > Integer.MAX_VALUE / 10)
        throw new RuntimeException();
      y *= 10;
      if (y > Integer.MAX_VALUE - x % 10)
        throw new RuntimeException();
      y += x % 10;
      x /= 10;
    }
    return y;
  }
}
