import java.util.Random;

public class Solution
{
  private Random rand = new Random();

  private int find (int[] nums, int begin, int end, int k)
  {
    int f = begin, e = end - 1;
    int x = nums[rand.nextInt(end - begin) + begin];
    while (f <= e)
    {
      while (f <= e && nums[f] < x)
        ++f;
      while (f <= e && nums[e] > x)
        --e;
      if (f <= e)
      {
        int t = nums[f];
        nums[f] = nums[e];
        nums[e] = t;
        ++f;
        --e;
      }
    }
    if (nums.length - k <= e)
      return find(nums, begin, e + 1, k);
    else if (nums.length - k >= f)
      return find(nums, f, end, k);
    else
      return x;
  }

  public int findKthLargest (int[] nums, int k)
  {
    if (nums == null)
      throw new IllegalArgumentException();
    return find(nums, 0, nums.length, k);
  }
}
