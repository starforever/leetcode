public class Solution
{
  public int firstMissingPositive (int[] A)
  {
    if (A == null)
      return 1;
    int N = A.length;
    boolean[] occur = new boolean[N];
    for (int i = 0; i < N; ++i)
      if (A[i] >= 1 && A[i] <= N)
        occur[A[i] - 1] = true;
    for (int i = 0; i < N; ++i)
      if (!occur[i])
        return i + 1;
    return N + 1;
  }
}
