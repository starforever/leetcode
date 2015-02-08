public class Solution
{
  public int removeDuplicates (int[] A)
  {
    int n = 0, i = 0;
    while (i < A.length)
    {
      A[n++] = A[i];
      while (i < A.length && A[i] == A[n - 1])
        ++i;
    }
    return n;
  }
}
