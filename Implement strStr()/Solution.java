public class Solution
{
  public String strStr (String haystack, String needle)
  {
    if (haystack == null || needle == null)
      return null;
    for (int i = 0; i + needle.length() <= haystack.length(); ++i)
    {
      if (haystack.substring(i, i + needle.length()).equals(needle))
        return haystack.substring(i);
    }
    return null;
  }
}
