public class Solution
{
  public void rotate (int[] nums, int k)
  {
    if (nums == null)
      throw new IllegalArgumentException();
    int n = nums.length;
    if (n == 0)
      return;
    k %= n;
    if (k == 0)
      return;
    int[] temp = new int[n];
    for (int i = 0; i < n - k; ++i)
      temp[i + k] = nums[i];
    for (int i = n - k; i < n; ++i)
      temp[i - (n - k)] = nums[i];
    for (int i = 0; i < n; ++i)
      nums[i] = temp[i];
  }
}
