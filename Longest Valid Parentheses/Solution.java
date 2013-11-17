public class Solution
{
  public int longestValidParentheses (String s)
  {
    if (s == null || s.isEmpty())
      return 0;
    int N = s.length();
    int[] start = new int[2 * N + 1];
    for (int i = 0; i <= 2 * N; ++i)
      start[i] = -1;
    start[N] = 0;
    int level = 0;
    int maxLength = 0;
    for (int i = 0; i < N; ++i)
    {
      if (s.charAt(i) == '(')
        ++level;
      else
      {
        start[level + N] = -1;
        --level;
      }
      if (start[level + N] != -1)
        maxLength = Math.max(maxLength, i + 1 - start[level + N]);
      else
        start[level + N] = i + 1;
    }
    return maxLength;
  }
}
