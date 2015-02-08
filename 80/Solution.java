public class Solution
{
  public int removeDuplicates (int[] A)
  {
    int n = 0;
    int i = 0;
    while (i < A.length)
    {
      int j = i + 1;
      while (j < A.length && A[j] == A[i])
        ++j;
      A[n++] = A[i];
      if (j - i >= 2)
        A[n++] = A[i];
      i = j;
    }
    return n;
  }
}
