public class Solution
{

  int N;
  int[] A;

  void swap (int i, int j)
  {
    int t = A[i];
    A[i] = A[j];
    A[j] = t;
  }

  public int firstMissingPositive (int[] A)
  {
    this.A = A;
    N = A.length;
    int i = 0;
    while (i < N)
    {
      if (A[i] >= 1 && A[i] <= N && A[A[i] - 1] != A[i])
        swap(i, A[i] - 1);
      else
        ++i;
    }
    for (i = 0; i < N; ++i)
    {
      if (A[i] != i + 1)
        return i + 1;
    }
    return N + 1;
  }

}
