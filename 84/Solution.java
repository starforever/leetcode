public class Solution
{

  static class Bar
  {
    int idx;
    int height;

    public Bar (int idx, int height)
    {
      this.idx = idx;
      this.height = height;
    }
  }

  int[] calcSpan (int[] height)
  {
    int n = height.length;
    int[] span = new int[n];
    Stack<Bar> stack = new Stack<Bar>();
    for (int i = 0; i < n; ++i)
    {
      while (!stack.empty() && stack.peek().height >= height[i])
        stack.pop();
      if (!stack.empty())
        span[i] = i - 1 - stack.peek().idx;
      else
        span[i] = i;
      stack.push(new Bar(i, height[i]));
    }
    return span;
  }

  void reverse (int[] arr)
  {
    int n = arr.length;
    for (int i = 0; i < n / 2; ++i)
    {
      int tmp = arr[i];
      arr[i] = arr[n - 1 - i];
      arr[n - 1 - i] = tmp;
    }
  }

  public int largestRectangleArea (int[] height)
  {
    int[] leftSpan = calcSpan(height);
    reverse(height);
    int[] rightSpan = calcSpan(height);
    reverse(rightSpan);
    reverse(height);
    int maxArea = 0;
    for (int i = 0; i < height.length; ++i)
      maxArea = Math.max(maxArea, (leftSpan[i] + rightSpan[i] + 1) * height[i]);
    return maxArea;
  }

}
