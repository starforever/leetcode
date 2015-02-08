public class Solution
{
  public int longestValidParentheses (String s)
  {
    int N = s.length();
    int[] start = new int[2 * N + 1];
    Arrays.fill(start, -1);
    start[N] = 0;
    int level = 0;
    int maxLength = 0;
    for (int i = 0; i < N; ++i)
    {
      if (s.charAt(i) == '(')
        ++level;
      else // if (s.charAt(i) == ')')
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
