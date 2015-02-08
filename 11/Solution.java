public class Solution
{
  public int maxArea (int[] height)
  {
    int left = 0, right = height.length - 1;
    int maxArea = 0;
    while (right - left >= 1)
    {
      int low = Math.min(height[left], height[right]);
      maxArea = Math.max(maxArea, (right - left) * low);
      if (height[left] == low)
        ++left;
      if (height[right] == low)
        --right;
    }
    return maxArea;
  }
}
