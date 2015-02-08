public class Solution
{
  public int sqrt (int x)
  {
    int l = 0, r = Math.min(x, 46340) + 1;
    while (r - l > 1)
    {
      int m = (l + r) / 2;
      if (m * m <= x)
        l = m;
      else
        r = m;
    }
    return l;
  }
}
