public class Solution
{
  private int rotate (int[] nums, int k, int s)
  {
    int cnt = 1;
    int n = nums.length;
    int t = nums[s];
    int i = s, j = (i - k + n) % n;
    while (j != s)
    {
      ++cnt;
      nums[i] = nums[j];
      i = j;
      j -= k;
      if (j < 0)
        j += n;
    }
    nums[i] = t;
    return cnt;
  }

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
    int m = 0;
    int i = 0;
    while (m < n)
      m += rotate(nums, k, i++);
  }
}
