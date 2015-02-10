public class Solution
{
  public int findPeakElement (int[] num)
  {
    if (num == null || num.length == 0)
      throw new IllegalArgumentException();
    int f = 0, e = num.length;
    while (e - f > 1)
    {
      int m = (f + e - 1) / 2;
      int hl = m - 1 >= 0 ? num[m - 1] : Integer.MIN_VALUE;
      int hr = m + 1 < num.length ? num[m + 1] : Integer.MIN_VALUE;
      if (num[m] > hl && num[m] > hr)
        return m;
      if (num[m] < hl)
        e = m;
      else
        f = m + 1;
    }
    return f;
  }
}
