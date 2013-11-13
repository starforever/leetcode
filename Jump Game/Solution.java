public class Solution
{
  public boolean canJump (int[] A)
  {
    if (A == null || A.length == 0)
      return false;
    int N = A.length;
    boolean[] reach = new boolean[N];
    reach[N - 1] = true;
    for (int i = N - 2; i >= 0; --i)
    {
      reach[i] = false;
      for (int j = i + 1; j < N && j - i <= A[i]; ++j)
        if (reach[j])
        {
          reach[i] = true;
          break;
        }
    }
    return reach[0];
  }
}
