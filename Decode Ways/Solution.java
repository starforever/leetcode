public class Solution
{
  public int numDecodings (String s)
  {
    int n = s.length();
    if (n == 0)
      return 0;
    int[] num = new int[n + 1];
    num[0] = 1;
    num[1] = s.charAt(0) != '0' ? 1 : 0;
    for (int i = 2; i <= n; ++i)
    {
      num[i] = 0;
      char a = s.charAt(i - 2), b = s.charAt(i - 1);
      if (b != '0')
        num[i] += num[i - 1];
      if (a == '1' || a == '2' && b <= '6')
        num[i] += num[i - 2];
    }
    return num[n];
  }
}
