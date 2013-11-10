public class Solution
{

  boolean check (String s)
  {
    if (s.length() > 1 && s.charAt(0) == '0')
      return false;
    return Integer.valueOf(s) <= 255;
  }

  public ArrayList<String> restoreIpAddresses (String s)
  {
    ArrayList<String> ret = new ArrayList<String>();
    int n = s.length();
    for (int p1 = Math.max(1, n - 9); p1 <= Math.min(3, n - 3); ++p1)
    {
      String s1 = s.substring(0, p1);
      if (!check(s1))
        continue;
      for (int p2 = Math.max(p1 + 1, n - 6); p2 <= Math.min(p1 + 3, n - 2); ++p2)
      {
        String s2 = s.substring(p1, p2);
        if (!check(s2))
          continue;
        for (int p3 = Math.max(p2 + 1, n - 3); p3 <= Math.min(p2 + 3, n - 1); ++p3)
        {
          String s3 = s.substring(p2, p3), s4 = s.substring(p3, n);
          if (check(s3) && check(s4))
            ret.add(String.format("%s.%s.%s.%s", s1, s2, s3, s4));
        }
      }
    }
    return ret;
  }

}
