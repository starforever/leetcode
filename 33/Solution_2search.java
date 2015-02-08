public class Solution
{

  int findPivot (int[] A)
  {
    int l = 0, r = A.length;
    int last = A[A.length - 1];
    while (r - l > 1)
    {
      int m = (l + r - 1) / 2;
      if (A[m] <= last)
        r = m + 1;
      else
        l = m + 1;
    }
    return l;
  }

  public int search (int[] A, int target)
  {
    if (A == null || A.length == 0)
      return -1;
    int p = findPivot(A);
    boolean left = target > A[A.length - 1];
    int l = left ? 0 : p;
    int r = left ? p : A.length;
    while (r - l > 0)
    {
      int m = (l + r) / 2;
      if (A[m] == target)
        return m;
      if (A[m] > target)
        r = m;
      else
        l = m + 1;
    }
    return -1;
  }

}
