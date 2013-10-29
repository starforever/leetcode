public class Solution
{
  public boolean isMatch (String ss, String ps)
  {
    char[] s = ss.toCharArray(), p = ps.toCharArray();
    int N = s.length, M = p.length;
    int i = 0, j = 0;
    int li = -1, lj = -1;
    while (i < N || j < M)
    {
      if (i < N && j < M && (s[i] == p[j] || p[j] == '?'))
      {
        ++i;
        ++j;
      }
      else if (j < M && p[j] == '*')
      {
        while (j < M && p[j] == '*')
          ++j;
        if (j == M)
          return true;
        if (i == N)
          return false;
        li = i;
        lj = j;
      }
      else if (i < N && (j == M || s[i] != p[j]))
      {
        if (lj == -1)
          return false;
        i = ++li;
        j = lj;
      }
      else
        return false;
    }
    return true;
  }
}
