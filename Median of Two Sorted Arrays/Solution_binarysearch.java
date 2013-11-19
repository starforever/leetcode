public class Solution
{

  int check (int x, int[] A, int k)
  {
    if (k - 1 >= A.length || k - 1 >= 0 && A[k - 1] > x)
      return 1;
    if (k < A.length && A[k] < x)
      return -1;
    return 0;
  }

  int findKth (int k, int[] A, int[] B)
  {
    int start = 0, end = Math.min(A.length, k + 1);
    while (end - start > 0)
    {
      int mid = (start + end) / 2;
      int r = check(A[mid], B, k - mid);
      if (r == 0)
        return A[mid];
      if (r == -1)
        end = mid;
      else
        start = mid + 1;
    }
    return findKth(k, B, A);
  }

  public double findMedianSortedArrays (int[] A, int[] B)
  {
    if (A == null)
      A = new int[0];
    if (B == null)
      B = new int[0];
    int N = A.length, M = B.length;
    if (N + M == 0)
      return 0.0;
    if ((N + M) % 2 == 1)
      return findKth((N + M) / 2, A, B);
    else
      return (findKth((N + M) / 2, A, B) + findKth((N + M) / 2 - 1, A, B)) * 0.5;
  }

}
