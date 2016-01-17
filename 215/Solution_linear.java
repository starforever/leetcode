import java.util.Random;

public class Solution
{
  private Random rand = new Random();

  private void swap (int[] nums, int i, int j)
  {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }

  private int find (int[] nums, int lo, int hi, int k)
  {
    swap(nums, lo, rand.nextInt(hi - lo) + lo);
    int j = lo + 1;
    for (int i = lo + 1; i < hi; ++i)
    {
      if (nums[i] <= nums[lo])
        swap(nums, i, j++);
    }
    swap(nums, lo, --j);
    if (nums.length - k > j)
      return find(nums, j + 1, hi, k);
    else if (nums.length - k < j)
      return find(nums, lo, j, k);
    else
      return nums[j];
}

  public int findKthLargest (int[] nums, int k)
  {
    if (nums == null)
      throw new IllegalArgumentException();
    return find(nums, 0, nums.length, k);
  }
}
