import java.util.BitSet;

public class Solution
{
  public int lengthOfLongestSubstring (String s)
  {
    if (s == null)
      throw new IllegalArgumentException();
    BitSet usedChar = new BitSet(128);
    int front = 0, back = 0;
    while (front < s.length() && !usedChar.get((int)s.charAt(front)))
      usedChar.flip((int)s.charAt(front++));
    int maxLen = front;
    while (front < s.length())
    {
      usedChar.flip((int)s.charAt(back++));
      while (front < s.length() && !usedChar.get((int)s.charAt(front)))
        usedChar.flip((int)s.charAt(front++));
      maxLen = Math.max(maxLen, front - back);
    }
    return maxLen;
  }
}
