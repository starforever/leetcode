public class Solution
{
  public int atoi (String str)
  {
    int index = 0;
    while (index < str.length() && Character.isWhitespace(str.charAt(index)))
      ++index;
    boolean isPositive = true;
    if (index < str.length() && (str.charAt(index) == '+' || str.charAt(index) == '-'))
    {
      isPositive = str.charAt(index) == '+';
      ++index;
    }
    int num = 0;
    boolean overflow = false;
    while (!overflow && index < str.length() && Character.isDigit(str.charAt(index)))
    {
      int d = str.charAt(index) - '0';
      if (num > Integer.MAX_VALUE / 10)
        overflow = true;
      num *= 10;
      if (num > Integer.MAX_VALUE - d)
        overflow = true;
      num += d;
      ++index;
    }
    if (overflow)
      return isPositive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
    else
      return isPositive ? num : -num;
  }
}
