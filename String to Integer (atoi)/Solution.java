public class Solution
{
  public int atoi (String str)
  {
    if (str == null || str.isEmpty())
      throw new RuntimeException();
    int i = 0;
    boolean positive = true;
    while (i < str.length() && str.charAt(i) == '-')
    {
      positive = !positive;
      ++i;
    }
    if (i == str.length())
      throw new RuntimeException();
    long num = 0;
    while (i < str.length() && num <= -(long)Integer.MIN_VALUE)
    {
      if (!(str.charAt(i) >= '0' && str.charAt(i) <= '9'))
        throw new RuntimeException();
      num = num * 10 + (str.charAt(i) - '0');
      ++i;
    }
    if (!positive)
      num = -num;
    if (num < Integer.MIN_VALUE || num > Integer.MAX_VALUE)
      throw new RuntimeException();
    return (int)num;
  }
}
