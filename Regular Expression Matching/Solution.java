public class Solution
{
  public boolean isMatch (String s, String p)
  {
    if (s == null || p == null)
      return false;
    int N = s.length(), M = p.length();
    boolean[][] match = new boolean[N + 1][M + 1];
    match[0][0] = true;
    for (int i = 1; i <= N; ++i)
      match[i][0] = false;
    for (int i = 0; i <= N; ++i)
      for (int j = 1; j <= M; ++j)
      {
        match[i][j] = false;
        if (p.charAt(j - 1) == '*')
        {
          if (j < 2 || p.charAt(j - 2) == '*')
            return false;
          match[i][j] |= match[i][j - 2];
          if (i > 0 && (p.charAt(j - 2) == '.' || p.charAt(j - 2) == s.charAt(i - 1)))
            match[i][j] |= match[i - 1][j];
        }
        else
        {
          if (i > 0 && (p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i - 1)))
            match[i][j] |= match[i - 1][j - 1];
        }
      }
    return match[N][M];
  }
}
