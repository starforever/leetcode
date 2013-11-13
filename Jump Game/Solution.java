public class Solution
{
  public boolean canJump (int[] A)
  {
    if (A == null || A.length == 0)
      return false;
    int N = A.length;
    int last = N - 1;
    for (int i = N - 2; i >= 0; --i)
    {
      if (last - i <= A[i])
        last = i;
    }
    return last == 0;
  }
}
