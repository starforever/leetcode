public class Solution
{
  public int search (int[] A, int target)
  {
    if (A == null || A.length == 0)
      return -1;
    int l = 0, r = A.length;
    int last = A[A.length - 1];
    while (r - l > 0)
    {
      int m = (l + r) / 2;
      if (A[m] == target)
        return m;
      if (A[m] < target)
      {
        if (target <= last)
          l = m + 1;
        else
        {
          if (A[m] <= last)
            r = m;
          else
            l = m + 1;
        }
      }
      else
      {
        if (target <= last)
        {
          if (A[m] <= last)
            r = m;
          else
            l = m + 1;
        }
        else
          r = m;
      }
    }
    return -1;
  }
}
