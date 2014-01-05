public class Solution
{

  int findKth (int k, int[] A, int startA, int lenA, int[] B, int startB, int lenB)
  {
    if (lenA > lenB)
      return findKth(k, B, startB, lenB, A, startA, lenA);
    if (lenA == 0)
      return B[startB + k];
    if (k == 0)
      return Math.min(A[startA], B[startB]);
    int kA = Math.min((k + 1) / 2, lenA), kB = k + 1 - kA;
    if (A[startA + kA - 1] < B[startB + kB - 1])
      return findKth(k - kA, A, startA + kA, lenA - kA, B, startB, lenB);
    else
      return findKth(k - kB, A, startA, lenA, B, startB + kB, lenB - kB);
  }

  public double findMedianSortedArrays (int[] A, int[] B)
  {
    int N = A.length + B.length;
    if (N == 0)
      return 0.0;
    if (N % 2 == 1)
      return findKth(N / 2, A, 0, A.length, B, 0, B.length);
    else
      return (findKth(N / 2 - 1, A, 0, A.length, B, 0, B.length) + findKth(N / 2, A, 0, A.length, B, 0, B.length)) * 0.5;
  }

}
