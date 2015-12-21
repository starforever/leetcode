public class Solution
{
  public int minSubArrayLen (int s, int[] nums)
  {
    if (nums == null)
      throw new IllegalArgumentException();
    int f = 0, e = 0;
    long sum = 0;
    int size = Integer.MAX_VALUE;
    while (true)
    {
      while (e < nums.length && sum < s)
        sum += nums[e++];
      if (sum < s)
        break;
      size = Math.min(size, e - f);
      sum -= nums[f++];
    }
    if (size == Integer.MAX_VALUE)
      size = 0;
    return size;
  }
}
