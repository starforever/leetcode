public class Solution
{
  public int maximalRectangle (char[][] matrix)
  {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
      return 0;
    int N = matrix.length, M = matrix[0].length;
    int[][] sum = new int[N][M];
    for (int i = 0; i < N; ++i)
      for (int j = 0; j < M; ++j)
      {
        sum[i][j] = matrix[i][j] == '1' ? 1 : 0;
        if (i > 0)
          sum[i][j] += sum[i - 1][j];
        if (j > 0)
          sum[i][j] += sum[i][j - 1];
        if (i > 0 && j > 0)
          sum[i][j] -= sum[i - 1][j - 1];
      }
    int maxS = 0;
    for (int i1 = 0; i1 < N; ++i1)
      for (int i2 = i1; i2 < N; ++i2)
        for (int j1 = 0; j1 < M; ++j1)
          for (int j2 = j1; j2 < M; ++j2)
          {
            int s = sum[i2][j2];
            if (i1 > 0)
              s -= sum[i1 - 1][j2];
            if (j1 > 0)
              s -= sum[i2][j1 - 1];
            if (i1 > 0 && j1 > 0)
              s += sum[i1 - 1][j1 - 1];
            if (s == (i2 - i1 + 1) * (j2 - j1 + 1) && s > maxS)
              maxS = s;
          }
    return maxS;
  }
}
