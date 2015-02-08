public class Solution
{

  int longestLength (String s, int i1, int i2)
  {
    int len = 0;
    while (i1 >= 0 && i2 < s.length() && s.charAt(i1) == s.charAt(i2))
    {
      ++len;
      --i1;
      ++i2;
    }
    return len;
  }

  public String longestPalindrome (String s)
  {
    if (s == null)
      return "";
    String sub = "";
    for (int i = 0; i < s.length(); ++i)
    {
      int len = longestLength(s, i - 1, i + 1);
      if (len * 2 + 1 > sub.length())
        sub = s.substring(i - len, i + len + 1);
      len = longestLength(s, i - 1, i);
      if (len * 2 > sub.length())
        sub = s.substring(i - len, i + len);
    }
    return sub;
  }

}
