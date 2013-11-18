public class Solution
{

  static class Vertical
  {
    int pos;
    int height;

    public Vertical (int pos, int height)
    {
      this.pos = pos;
      this.height = height;
    }
  }

  int N;
  int[] height;

  int findHigherLeft (Vertical[] left, int end, int lowHeight)
  {
    int start = 0;
    while (end - start > 1)
    {
      int mid = (start + end - 1) / 2;
      if (left[mid].height >= lowHeight)
        end = mid + 1;
      else
        start = mid + 1;
    }
    return left[start].pos;
  }

  int solve ()
  {
    int L = 0;
    Vertical[] left = new Vertical[N];
    left[L++] = new Vertical(0, height[0]);
    int maxArea = 0;
    for (int i = 1; i < N; ++i)
    {
      if (height[i] > left[L - 1].height)
        left[L++] = new Vertical(i, height[i]);
      else
      {
        int j = findHigherLeft(left, L, height[i]);
        maxArea = Math.max(maxArea, (i - j) * height[i]);
      }
    }
    return maxArea;
  }

  void reverse ()
  {
    for (int i = 0; i < N / 2; ++i)
    {
      int tmp = height[i];
      height[i] = height[N - 1 - i];
      height[N - 1 - i] = tmp;
    }
  }

  public int maxArea (int[] height)
  {
    if (height == null || height.length < 2)
      return 0;
    N = height.length;
    this.height = height;
    int sol = solve();
    reverse();
    sol = Math.max(sol, solve());
    return sol;
  }

}
