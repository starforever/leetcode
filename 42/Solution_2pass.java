public class Solution
{
  public int trap (int[] A)
  {
    int N = A.length;
    int highest = 0;
    int[] right = new int[N];
    for (int i = N - 1; i >= 0; --i)
    {
      highest = Math.max(highest, A[i]);
      right[i] = highest;
    }
    int left = 0;
    int total = 0;
    for (int i = 0; i < A.length; ++i)
    {
      left = Math.max(left, A[i]);
      total += Math.min(left, right[i]) - A[i];
    }
    return total;
  }
}
