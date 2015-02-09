public class Solution
{
  public String reverseWords (String s)
  {
    StringBuilder sb = new StringBuilder();
    int i = s.length() - 1, j;
    while (true)
    {
      while (i >= 0 && s.charAt(i) == ' ')
        --i;
      if (i < 0)
        break;
      j = i;
      while (i >= 0 && s.charAt(i) != ' ')
        --i;
      if (sb.length() > 0)
        sb.append(' ');
      sb.append(s.substring(i + 1, j + 1));
    }
    return sb.toString();
  }
}
