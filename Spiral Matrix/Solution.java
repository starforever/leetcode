public class Solution
{
  public ArrayList<Integer> spiralOrder (int[][] matrix)
  {
    ArrayList<Integer> numList = new ArrayList<Integer>();
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
      return numList;
    int r = 0, c = 0, n = matrix.length, m = matrix[0].length;
    while (n >= 2 && m >= 2)
    {
      for (int i = 0; i < m; ++i)
        numList.add(matrix[r][c + i]);
      for (int i = 1; i < n; ++i)
        numList.add(matrix[r + i][c + m - 1]);
      for (int i = m - 2; i >= 0; --i)
        numList.add(matrix[r + n - 1][c + i]);
      for (int i = n - 2; i > 0; --i)
        numList.add(matrix[r + i][c]);
      ++r;
      ++c;
      n -= 2;
      m -= 2;
    }
    for (int i = 0; i < n; ++i)
      for (int j = 0; j < m; ++j)
        numList.add(matrix[r + i][c + j]);
    return numList;
  }
}
