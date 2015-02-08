public class Solution
{
  public int maximalRectangle (char[][] matrix)
  {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
      return 0;
    int N = matrix.length, M = matrix[0].length;
    int maxS = 0;
    int[] sum = new int[N];
    for (int x1 = 0; x1 < M; ++x1)
    {
      for (int y = 0; y < N; ++y)
        sum[y] = 0;
      for (int x2 = x1; x2 < M; ++x2)
      {
        for (int y = 0; y < N; ++y)
          if (matrix[y][x2] == '1')
            ++sum[y];
        int y1 = 0;
        while (y1 < N)
        {
          while (y1 < N && sum[y1] != x2 - x1 + 1)
            ++y1;
          int y2 = y1;
          while (y2 < N && sum[y2] == x2 - x1 + 1)
            ++y2;
          maxS = Math.max(maxS, (x2 - x1 + 1) * (y2 - y1));
          y1 = y2;
        }
      }
    }
    return maxS;
  }
}
