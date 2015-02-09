public class Solution
{
  public int findMin (int[] num)
  {
    if (num == null || num.length == 0)
      throw new IllegalArgumentException();
    int x = num[num.length - 1];
    int f = 0, e = num.length;
    while (e - f > 1)
    {
      int m = (f + e - 1) / 2;
      if (num[m] <= x)
        e = m + 1;
      else
        f = m + 1;
    }
    return num[f];
  }
}
