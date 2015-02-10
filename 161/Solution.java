public class Solution
{
  public boolean isOneEditDistance (String s, String t)
  {
    if (s.length() > t.length())
    {
      String tmp = s;
      s = t;
      t = tmp;
    }
    if (t.length() - s.length() >= 2)
      return false;
    int i = 0;
    while (i < s.length() && s.charAt(i) == t.charAt(i))
      ++i;
    if (i == s.length())
      return s.length() < t.length();
    if (s.length() == t.length())
      return s.substring(i + 1).equals(t.substring(i + 1));
    else
      return s.substring(i).equals(t.substring(i + 1));
  }
}
