public class Solution
{
  public int numDecodings (String s)
  {
    int n = s.length();
    if (n == 0)
      return 0;
    int last2 = 1, last1 = s.charAt(0) != '0' ? 1 : 0, cur = last1;
    for (int i = 2; i <= n; ++i)
    {
      cur = 0;
      char a = s.charAt(i - 2), b = s.charAt(i - 1);
      if (b != '0')
        cur += last1;
      if (a == '1' || a == '2' && b <= '6')
        cur += last2;
      last2 = last1;
      last1 = cur;
    }
    return cur;
  }
}
