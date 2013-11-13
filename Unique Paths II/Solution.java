public class Solution
{
  public int uniquePathsWithObstacles (int[][] obstacleGrid)
  {
    if (obstacleGrid == null)
      return 0;
    int N = obstacleGrid.length;
    if (N == 0)
      return 0;
    int M = obstacleGrid[0].length;
    if (M == 0)
      return 0;
    int[][] numPath = new int[N][M];
    numPath[0][0] = obstacleGrid[0][0] == 0 ? 1 : 0;
    for (int i = 1; i < M; ++i)
      numPath[0][i] = obstacleGrid[0][i] == 0 ? numPath[0][i - 1] : 0;
    for (int i = 1; i < N; ++i)
      numPath[i][0] = obstacleGrid[i][0] == 0 ? numPath[i - 1][0] : 0;
    for (int i = 1; i < N; ++i)
      for (int j = 1; j < M; ++j)
        numPath[i][j] = obstacleGrid[i][j] == 0 ? numPath[i - 1][j] + numPath[i][j - 1] : 0;
    return numPath[N - 1][M - 1];
  }
}
