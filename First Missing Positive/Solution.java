public class Solution
{
  public int firstMissingPositive (int[] A)
  {
    if (A == null)
      return 1;
    int N = A.length;
    int i = 0;
    while (i < N)
    {
      if (A[i] >= 1 && A[i] <= N && A[i] != i + 1 && A[A[i] - 1] != A[i])
      {
        int tmp = A[A[i] - 1];
        A[A[i] - 1] = A[i];
        A[i] = tmp;
      }
      else
        ++i;
    }
    for (i = 0; i < N; ++i)
      if (A[i] != i + 1)
        return i + 1;
    return N + 1;
  }
}
