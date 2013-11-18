public class Solution
{

  int N, M;
  int[] A, B;

  int findKth (int k, int start1, int end1, int start2, int end2)
  {
    int len1 = end1 - start1, len2 = end2 - start2;
    if (len1 == 0)
      return B[start2 + k];
    if (len2 == 0)
      return A[start1 + k];
    int mid1 = k * len1 / (len1 + len2), mid2 = k - mid1;
    if (mid2 >= len2)
    {
      mid1 += mid2 - (len2 - 1);
      mid2 = len2 - 1;
    }
    if (A[start1 + mid1] > B[start2 + mid2])
      return findKth(k - mid2, start1, start1 + mid1, start2 + mid2, end2);
    else
      return findKth(k - mid1, start1 + mid1, end1, start2, start2 + mid2);
  }

  public double findMedianSortedArrays (int[] A, int[] B)
  {
    N = A.length;
    M = B.length;
    this.A = A;
    this.B = B;
    if ((N + M) % 2 == 1)
      return findKth((N + M) / 2, 0, N, 0, M);
    else
      return (findKth((N + M) / 2, 0, N, 0, M) + findKth((N + M) / 2 - 1, 0, N, 0, M)) * 0.5;
  }

}
