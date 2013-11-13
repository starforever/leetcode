public class Solution
{
  public int maxSubArray (int[] A)
  {
    int n = A.length;
    int sum = 0;
    int minSum = 0;
    int maxSum = Integer.MIN_VALUE;
    for (int i = 0; i < n; ++i)
    {
      sum += A[i];
      maxSum = Math.max(maxSum, sum - minSum);
      minSum = Math.min(minSum, sum);
    }
    return maxSum;
  }
}
