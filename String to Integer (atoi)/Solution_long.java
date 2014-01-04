public class Solution
{
  public int atoi (String str)
  {
    if (str == null)
      return 0;
    int i = 0;
    while (i < str.length() && str.charAt(i) == ' ')
      ++i;
    boolean positive = true;
    if (i < str.length() && (str.charAt(i) == '-' || str.charAt(i) == '+'))
    {
      positive = str.charAt(i) == '+';
      ++i;
    }
    long num = 0;
    while (i < str.length() && Character.isDigit(str.charAt(i)) && num <= -(long)Integer.MIN_VALUE)
    {
      num = num * 10 + (str.charAt(i) - '0');
      ++i;
    }
    if (!positive)
      num = -num;
    if (num < Integer.MIN_VALUE)
      return Integer.MIN_VALUE;
    if (num > Integer.MAX_VALUE)
      return Integer.MAX_VALUE;
    return (int)num;
  }
}
