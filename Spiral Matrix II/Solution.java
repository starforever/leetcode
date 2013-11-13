public class Solution
{
  public int[][] generateMatrix (int n)
  {
    int[][] matrix = new int[n][n];
    int next = 1;
    int r = 0, c = 0;
    while (n >= 2)
    {
      for (int i = 0; i < n; ++i)
        matrix[r][c + i] = next++;
      for (int i = 1; i < n; ++i)
        matrix[r + i][c + n - 1] = next++;
      for (int i = n - 2; i >= 0; --i)
        matrix[r + n - 1][c + i] = next++;
      for (int i = n - 2; i > 0; --i)
        matrix[r + i][c] = next++;
      ++r;
      ++c;
      n -= 2;
    }
    if (n == 1)
      matrix[r][c] = next++;
    return matrix;
  }
}
