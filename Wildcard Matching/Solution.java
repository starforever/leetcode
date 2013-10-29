public class Solution
{
  public boolean isMatch (String s, String p)
  {
    int N = s.length(), M = p.length();
    boolean[][] match = new boolean[2][M + 1];
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
        int cur = i & 1, prev = cur ^ 1;
        if (b == '*')
          match[cur][j] = match[cur][j - 1] || match[prev][j];
        else if (b == '?')
          match[cur][j] = match[prev][j - 1];
        else
          match[cur][j] = (a == b) && match[prev][j - 1];
      }
    return match[N & 1][M];
  }
}
