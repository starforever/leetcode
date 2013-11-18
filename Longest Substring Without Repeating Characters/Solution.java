public class Solution
{
  public int lengthOfLongestSubstring (String s)
  {
    if (s == null)
      return 0;
    boolean[] inWin = new boolean[128];
    int start = 0, end = 0;
    while (end < s.length() && !inWin[s.charAt(end)])
      inWin[s.charAt(end++)] = true;
    int longestLen = end - start;
    while (end < s.length())
    {
      inWin[s.charAt(start++)] = false;
      while (end < s.length() && !inWin[s.charAt(end)])
        inWin[s.charAt(end++)] = true;
      longestLen = Math.max(longestLen, end - start);
    }
    return longestLen;
  }
}
