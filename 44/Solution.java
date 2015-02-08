public class Solution
{

  boolean match (String s, String p)
  {
    for (int i = 0; i < s.length(); ++i)
      if (!(s.charAt(i) == p.charAt(i) || p.charAt(i) == '?'))
        return false;
    return true;
  }

  public boolean isMatch (String s, String p)
  {
    if (s == null || p == null)
      return false;
    int front = p.indexOf('*'), back = p.length() - p.lastIndexOf('*') - 1;
    if (front == -1)
      return s.length() == p.length() && match(s, p);
    if (!(front + back <= s.length() && match(s.substring(0, front), p.substring(0, front)) && match(s.substring(s.length() - back), p.substring(p.length() - back))))
      return false;
    s = s.substring(front, s.length() - back);
    p = p.substring(front, p.length() - back);
    int i1 = 0, i2 = 0;
    while (true)
    {
      while (i2 < p.length() && p.charAt(i2) == '*')
        ++i2;
      if (i2 == p.length())
        break;
      int st = i2;
      while (p.charAt(i2) != '*')
        ++i2;
      String piece = p.substring(st, i2);
      while (i1 + piece.length() <= s.length() && !match(s.substring(i1, i1 + piece.length()), piece))
        ++i1;
      if (i1 + piece.length() > s.length())
        return false;
      i1 += piece.length();
    }
    return true;
  }
}
