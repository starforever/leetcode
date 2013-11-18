public class Solution
{
  public int reverse (int x)
  {
    if (x < 0)
      return -reverse(-x);
    int y = 0;
    while (x > 0)
    {
      int d = x % 10;
      x /= 10;
      y *= 10;
      y += d;
    }
    return y;
  }
}
