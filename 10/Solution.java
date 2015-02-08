public class Solution
{

  boolean isValid (String p)
  {
    if (p.length() > 0 && p.charAt(0) == '*')
      return false;
    for (int i = 1; i < p.length(); ++i)
      if (p.charAt(i) == '*' && p.charAt(i - 1) == '*')
        return false;
    return true;
  }

  public boolean isMatch (String s, String p)
  {
    if (!isValid(p))
      throw new RuntimeException();
    int N = s.length(), M = p.length();
    boolean[][] match = new boolean[N + 1][M + 1];
    match[0][0] = true;
    for (int i = 1; i <= N; ++i)
      match[i][0] = false;
    for (int j = 1; j <= M; ++j)
      match[0][j] = p.charAt(j - 1) == '*' && match[0][j - 2];
    for (int i = 1; i <= N; ++i)
      for (int j = 1; j <= M; ++j)
      {
        if (p.charAt(j - 1) != '*')
          match[i][j] = (p.charAt(j - 1) == '.' || s.charAt(i - 1) == p.charAt(j - 1)) && match[i - 1][j - 1];
        else
          match[i][j] = match[i][j - 2] || (p.charAt(j - 2) == '.' || s.charAt(i - 1) == p.charAt(j - 2)) && match[i - 1][j];
      }
    return match[N][M];
  }

}
