public class Solution
{
  public void reverseWords (char[] s)
  {
    for (int i = 0; i < s.length / 2; ++i)
    {
      char tmp = s[i];
      s[i] = s[s.length - 1 - i];
      s[s.length - 1 - i] = tmp;
    }
    for (int i = 0; i < s.length;)
    {
      int j = i;
      while (i < s.length && s[i] != ' ')
        ++i;
      for (int k = 0; k < (i - j) / 2; ++k)
      {
        char tmp = s[j + k];
        s[j + k] = s[i - 1 - k];
        s[i - 1 - k] = tmp;
      }
      ++i;
    }
  }
}
