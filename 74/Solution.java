public class Solution
{
  public boolean searchMatrix (int[][] matrix, int target)
  {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
      return false;
    int N = matrix.length, M = matrix[0].length;
    int f = 0, e = N * M;
    while (f < e)
    {
      int m = (f + e) / 2;
      int t = matrix[m / M][m % M];
      if (t == target)
        return true;
      else if (t < target)
        f = m + 1;
      else
        e = m;
    }
    return false;
  }
}
