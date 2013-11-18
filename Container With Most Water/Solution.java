public class Solution
{

  public int maxArea (int[] height)
  {
    if (height == null || height.length < 2)
      return 0;
    int left = 0, right = height.length - 1;
    int maxArea = 0;
    while (right - left >= 1)
    {
      maxArea = Math.max(maxArea, (right - left) * Math.min(height[left], height[right]));
      if (height[left] < height[right])
        ++left;
      else
        --right;
    }
    return maxArea;
  }

}
