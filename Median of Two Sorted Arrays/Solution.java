public class Solution
{

  int findKth (int k, int[] A, int start1, int len1, int[] B, int start2, int len2)
  {
    if (len1 > len2)
      return findKth(k, B, start2, len2, A, start1, len1);
    if (len1 == 0)
      return B[start2 + k];
    if (k == 0)
      return Math.min(A[start1], B[start2]);
    int mid1 = Math.min((k + 1) / 2, len1);
    int mid2 = k + 1 - mid1;
    if (A[start1 + mid1 - 1] < B[start2 + mid2 - 1])
      return findKth(k - mid1, A, start1 + mid1, len1 - mid1, B, start2, len2);
    else
      return findKth(k - mid2, A, start1, len1, B, start2 + mid2, len2 - mid2);
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
      return findKth((N + M) / 2, A, 0, N, B, 0, M);
    else
      return (findKth((N + M) / 2, A, 0, N, B, 0, M) + findKth((N + M) / 2 - 1, A, 0, N, B, 0, M)) * 0.5;
  }

}
