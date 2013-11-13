public class Solution
{
  public int uniquePaths (int m, int n)
  {
    if (m == 0 || n == 0)
      return 0;
    int[][] numPath = new int[m][n];
    numPath[0][0] = 1;
    for (int i = 1; i < n; ++i)
      numPath[0][i] = 1;
    for (int i = 1; i < m; ++i)
      numPath[i][0] = 1;
    for (int i = 1; i < m; ++i)
      for (int j = 1; j < n; ++j)
        numPath[i][j] = numPath[i - 1][j] + numPath[i][j - 1];
    return numPath[m - 1][n - 1];
  }
}
