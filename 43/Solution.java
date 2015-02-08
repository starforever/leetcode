public class Solution
{
  public String multiply (String num1, String num2)
  {
    int n1 = num1.length(), n2 = num2.length();
    int[] res = new int[n1 + n2];
    for (int i = 0; i < n1; ++i)
    {
      int x = 0;
      int d1 = num1.charAt(n1 - 1 - i) - '0';
      for (int j = 0; j < n2; ++j)
      {
        int d2 = num2.charAt(n2 - 1 - j) - '0';
        x += res[i + j] + d1 * d2;
        res[i + j] = x % 10;
        x /= 10;
      }
      if (x != 0)
        res[i + n2] = x;
    }
    StringBuilder sb = new StringBuilder();
    int i = n1 + n2 - 1;
    while (i > 0 && res[i] == 0)
      --i;
    while (i >= 0)
    {
      sb.append((char)(res[i] + '0'));
      --i;
    }
    return sb.toString();
  }
}
