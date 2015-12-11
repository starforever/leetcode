public class Solution
{
  public int rob (int[] nums)
  {
    if (nums == null)
      throw new IllegalArgumentException();
    int N = nums.length;
    if (N == 0)
      return 0;
    int dp[] = new int[]{0, nums[0]};
    for (int i = 2; i <= N; ++i)
    {
      dp[i & 1] = Math.max(dp[i & 1] + nums[i - 1], dp[i & 1 ^ 1]);
    }
    return dp[N & 1];
  }
}
