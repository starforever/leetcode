public class Solution
{

  long reverse (long x)
  {
    long y = 0;
    while (x > 0)
    {
      y = y * 10 + x % 10;
      x /= 10;
    }
    return y;
  }

  public boolean isPalindrome (int x)
  {
    if (x < 0)
      return false;
    long y = reverse((long)x);
    return x == y;
  }

}
