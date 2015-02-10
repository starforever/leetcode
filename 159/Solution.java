public class Solution
{
  public int lengthOfLongestSubstringTwoDistinct (String s)
  {
    if (s == null)
      throw new IllegalArgumentException();
    if (s.isEmpty())
      return 0;
    int maxSub = 1;
    int sub1 = 1, sub2 = 1;
    char otherChar = s.charAt(0);
    for (int i = 1; i < s.length(); ++i)
    {
      if (s.charAt(i) == s.charAt(i - 1))
      {
        ++sub1;
        ++sub2;
      }
      else
      {
        if (s.charAt(i) == otherChar)
          sub2 = sub2 + 1;
        else
          sub2 = sub1 + 1;
        otherChar = s.charAt(i - 1);
        sub1 = 1;
      }
      if (sub2 > maxSub)
        maxSub = sub2;
    }
    return maxSub;
  }
}
