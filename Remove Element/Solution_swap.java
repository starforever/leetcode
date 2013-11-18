public class Solution
{
  public int removeElement (int[] A, int elem)
  {
    int n = A.length, i = 0;
    while (i < n)
    {
      if (A[i] == elem)
      {
        int tmp = A[i];
        A[i] = A[n - 1];
        A[n - 1] = tmp;
        --n;
      }
      else
        ++i;
    }
    return n;
  }
}
