public class Solution
{
  public boolean isPalindrome (String s)
  {
    int n = s.length();
    int p = 0, q = n - 1;
    while (true)
    {
      while (p < q && !Character.isLetterOrDigit(s.charAt(p)))
        ++p;
      while (q > p && !Character.isLetterOrDigit(s.charAt(q)))
        --q;
      if (p >= q)
        return true;
      if (Character.toLowerCase(s.charAt(p)) != Character.toLowerCase(s.charAt(q)))
        return false;
      ++p;
      --q;
    }
  }
}
