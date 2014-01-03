public class Solution
{

  int findKth (int k, int[] A, int[] B)
  {
    int start = Math.max(0, k - B.length), end = Math.min(A.length, k + 1);
    while (end - start > 0)
    {
      int mid = (start + end) / 2;
      if (k - mid < B.length && B[k - mid] < A[mid])
        end = mid;
      else if (k - mid - 1 >= 0 && B[k - mid - 1] > A[mid])
        start = mid + 1;
      else
        return A[mid];
    }
    return findKth(k, B, A);
  }

  public double findMedianSortedArrays (int[] A, int[] B)
  {
    int N = A.length + B.length;
    if (N == 0)
      return 0.0;
    if (N % 2 == 1)
      return findKth(N / 2, A, B);
    else
      return (findKth(N / 2 - 1, A, B) + findKth(N / 2, A, B)) * 0.5;
  }

}
