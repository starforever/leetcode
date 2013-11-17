public class Solution
{

  boolean match (String str1, String str2)
  {
    for (int i = 0; i < str2.length(); ++i)
      if (str1.charAt(i) != str2.charAt(i))
        return false;
    return true;
  }

  public String strStr (String haystack, String needle)
  {
    if (haystack == null || needle == null)
      return null;
    for (int i = 0; i + needle.length() <= haystack.length(); ++i)
    {
      if (match(haystack.substring(i, i + needle.length()), needle))
        return haystack.substring(i);
    }
    return null;
  }

}
