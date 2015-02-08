public class Solution
{
  public boolean isScramble (String s1, String s2)
  {
    if (s1 == null || s2 == null)
      return false;
    int n = s1.length();
    if (s2.length() != n)
      return false;
    boolean[][][] check = new boolean[n + 1][n][n];
    for (int i = 0; i < n; ++i)
      for (int j = 0; j < n; ++j)
        check[1][i][j] = s1.charAt(i) == s2.charAt(j);
    for (int l = 2; l <= n; ++l)
      for (int i = 0; i + l <= n; ++i)
        for (int j = 0; j + l <= n; ++j)
        {
          check[l][i][j] = false;
          for (int l1 = 1; l1 < l; ++l1)
          {
            int l2 = l - l1;
            if (check[l1][i][j] && check[l2][i + l1][j + l1] || check[l1][i][j + l2] && check[l2][i + l1][j])
            {
              check[l][i][j] = true;
              break;
            }
          }
       }
    return check[n][0][0];
  }
}
