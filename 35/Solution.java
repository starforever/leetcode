public class Solution
{
  public int searchInsert (int[] A, int target)
  {
    if (A == null || A.length == 0)
      return 0;
    int l = 0, r = A.length;
    while (r - l > 1)
    {
      int m = (l + r - 1) / 2;
      if (A[m] >= target)
        r = m + 1;
      else
        l = m + 1;
    }
    if (A[l] >= target)
      return l;
    else
      return A.length;
  }
}
