public class Solution
{
  public int lengthOfLongestSubstring (String s)
  {
    int usedChar = 0;
    int front = 0, back = 0;
    while (front < s.length() && (usedChar & 1 << s.charAt(front) - 'a') == 0)
      usedChar ^= 1 << s.charAt(front++) - 'a';
    int maxLen = front;
    while (front < s.length())
    {
      usedChar ^= 1 << s.charAt(back++) - 'a';
      while (front < s.length() && (usedChar & 1 << s.charAt(front) - 'a') == 0)
        usedChar ^= 1 << s.charAt(front++) - 'a';
      maxLen = Math.max(maxLen, front - back);
    }
    return maxLen;
  }
}
