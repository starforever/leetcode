public class Solution
{
  private int findSol (int[] nums, int f, int e)
  {
    if (f >= e)
      return 0;
    int[] dp = new int[2];
    for (int i = e - 1; i >= f; --i)
    {
      dp[i & 1] = Math.max(dp[i & 1 ^ 1], nums[i] + dp[i & 1]);
    }
    return dp[f & 1];
  }

  public int rob (int[] nums)
  {
    if (nums == null)
      throw new IllegalArgumentException();
    if (nums.length == 0)
      return 0;
    int sol1 = findSol(nums, 1, nums.length);
    int sol2 = nums[0] + findSol(nums, 2, nums.length - 1);
    return Math.max(sol1, sol2);
  }
}
