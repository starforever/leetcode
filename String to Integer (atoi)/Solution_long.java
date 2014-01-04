public class Solution
{
  public int atoi (String str)
  {
    int index = 0;
    while (index < str.length() && Character.isWhitespace(str.charAt(index)))
      ++index;
    boolean isPositive = true;
    if (index < str.length() && (str.charAt(index) == '-' || str.charAt(index) == '+'))
    {
      isPositive = str.charAt(index) == '+';
      ++index;
    }
    long num = 0;
    while (index < str.length() && Character.isDigit(str.charAt(index)) && num <= -(long)Integer.MIN_VALUE)
    {
      num = num * 10 + (str.charAt(index) - '0');
      ++index;
    }
    if (!isPositive)
      num = -num;
    if (num < Integer.MIN_VALUE)
      return Integer.MIN_VALUE;
    if (num > Integer.MAX_VALUE)
      return Integer.MAX_VALUE;
    return (int)num;
  }
}
