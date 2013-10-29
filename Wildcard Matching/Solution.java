public class Solution
{
  public boolean isMatch (String s, String p)
  {
    int N = s.length(), M = p.length();
    boolean[][] match = new boolean[N + 1][M + 1];
    match[0][0] = true;
    for (int j = 1; j <= M; ++j)
      if (p.charAt(j - 1) == '*')
        match[0][j] = true;
      else
        break;
    for (int i = 1; i <= N; ++i)
      for (int j = 1; j <= M; ++j)
      {
        char a = s.charAt(i - 1), b = p.charAt(j - 1);
        if (b == '*')
          match[i][j] = match[i][j - 1] || match[i - 1][j];
        else if (b == '?')
          match[i][j] = match[i - 1][j - 1];
        else
          match[i][j] = (a == b) && match[i - 1][j - 1];
      }
    return match[N][M];
  }
}
