public class Solution
{
  public int minPathSum (int[][] grid)
  {
    if (grid == null)
      return 0;
    int N = grid.length;
    if (N == 0)
      return 0;
    int M = grid[0].length;
    if (M == 0)
      return 0;
    int[][] minSum = new int[N][M];
    minSum[0][0] = grid[0][0];
    for (int i = 1; i < M; ++i)
      minSum[0][i] = minSum[0][i - 1] + grid[0][i];
    for (int i = 1; i < N; ++i)
      minSum[i][0] = minSum[i - 1][0] + grid[i][0];
    for (int i = 1; i < N; ++i)
      for (int j = 1; j < M; ++j)
        minSum[i][j] = Math.min(minSum[i - 1][j], minSum[i][j - 1]) + grid[i][j];
    return minSum[N - 1][M - 1];
  }
}
