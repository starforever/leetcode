public class Solution
{

  int N, M;
  int[][] matrix;

  int[] findZero ()
  {
    for (int i = 0; i < N; ++i)
      for (int j = 0; j < M; ++j)
        if (matrix[i][j] == 0)
          return new int[]{i, j};
    return new int[]{-1, -1};
  }

  public void setZeroes (int[][] matrix)
  {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
      return;
    N = matrix.length;
    M = matrix[0].length;
    this.matrix = matrix;
    int[] pz = findZero();
    if (pz[0] == -1 && pz[1] == -1)
      return;
    for (int i = 0; i < N; ++i)
      matrix[i][pz[1]] = matrix[i][pz[1]] == 0 ? 1 : 0;
    for (int j = 0; j < M; ++j)
      matrix[pz[0]][j] = matrix[pz[0]][j] == 0 ? 1 : 0;
    for (int i = 0; i < N; ++i)
      if (i != pz[0])
        for (int j = 0; j < M; ++j)
          if (j != pz[1] && matrix[i][j] == 0)
          {
            matrix[i][pz[1]] = 1;
            matrix[pz[0]][j] = 1;
          }
    for (int i = 0; i < N; ++i)
      if (i != pz[0])
        for (int j = 0; j < M; ++j)
          if (j != pz[1] && (matrix[i][pz[1]] == 1 || matrix[pz[0]][j] == 1))
            matrix[i][j] = 0;
    for (int i = 0; i < N; ++i)
      matrix[i][pz[1]] = 0;
    for (int j = 0; j < M; ++j)
      matrix[pz[0]][j] = 0;
  }
}
