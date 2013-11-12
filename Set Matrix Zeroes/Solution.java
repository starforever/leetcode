public class Solution
{
  public void setZeroes (int[][] matrix)
  {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
      return;
    int N = matrix.length, M = matrix[0].length;
    boolean[] zeroRow = new boolean[N], zeroCol = new boolean[M];
    for (int i = 0; i < N; ++i)
      for (int j = 0; j < M; ++j)
        if (matrix[i][j] == 0)
          zeroRow[i] = zeroCol[j] = true;
    for (int i = 0; i < N; ++i)
      for (int j = 0; j < M; ++j)
        if (zeroRow[i] || zeroCol[j])
          matrix[i][j] = 0;
  }
}
