public class Solution
{
  private int[] findNext (String s)
  {
    int[] next = new int[s.length() + 1];
    next[0] = -1;
    next[1] = 0;
    int i = 1, j = 0;
    while (i < s.length())
    {
      while (j != -1 && s.charAt(j) != s.charAt(i))
        j = next[j];
      next[i + 1] = j + 1;
      ++i;
      ++j;
    }
    return next;
  }

  private int match (String s, int[] next)
  {
    int i = s.length() - 1, j = 0;
    while (i >= 0)
    {
      while (j != -1 && s.charAt(j) != s.charAt(i))
        j = next[j];
      --i;
      ++j;
    }
    return s.length() - j;
  }

  public String shortestPalindrome (String s)
  {
    if (s == null)
      throw new IllegalArgumentException();
    if (s.isEmpty())
      return s;
    int[] next = findNext(s);
    int len = match(s, next);
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < len; ++i)
      sb.append(s.charAt(s.length() - 1 - i));
    sb.append(s);
    return sb.toString();
  }
}
