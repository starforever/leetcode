public class Solution
{

  int[] A;

  int findStart (int T)
  {
    int l = 0, r = A.length;
    while (r - l > 1)
    {
      int m = (l + r - 1) / 2;
      if (A[m] >= T)
        r = m + 1;
      else
        l = m + 1;
    }
    return A[l] == T ? l : -1;
  }

  int findEnd (int T)
  {
    int l = 0, r = A.length;
    while (r - l > 1)
    {
      int m = (l + r) / 2;
      if (A[m] <= T)
        l = m;
      else
        r = m;
    }
    return A[l] == T ? l : -1;
  }

  public int[] searchRange (int[] A, int target)
  {
    if (A == null || A.length == 0)
      return new int[]{-1, -1};
    this.A = A;
    return new int[]{findStart(target), findEnd(target)};
  }

}
