public class Solution
{
  public int climbStairs (int n)
  {
    if (n < 2)
      return 1;
    int last1 = 1, last2 = 1;
    for (int i = 2; i <= n; ++i)
    {
      int cur = last1 + last2;
      last2 = last1;
      last1 = cur;
    }
    return last1;
  }
}
