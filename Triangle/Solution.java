public class Solution
{
  public int minimumTotal (ArrayList<ArrayList<Integer>> triangle)
  {
    if (triangle == null)
      return 0;
    int N = triangle.size();
    if (N == 0)
      return 0;
    int[] minPath = new int[N];
    for (int i = 0; i < N; ++i)
      minPath[i] = triangle.get(N - 1).get(i);
    for (int i = N - 2; i >= 0; --i)
    {
      for (int j = 0; j <= i; ++j)
        minPath[j] = triangle.get(i).get(j) + Math.min(minPath[j], minPath[j + 1]);
    }
    return minPath[0];
  }
}
