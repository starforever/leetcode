public class Solution
{

  int[] calcPrev (String needle)
  {
    int[] prev = new int[needle.length()];
    int j = -1;
    for (int i = 0; i < needle.length(); ++i)
    {
      prev[i] = j;
      while (j >= 0 && needle.charAt(j) != needle.charAt(i))
        j = prev[j];
      ++j;
    }
    return prev;
  }

  public String strStr (String haystack, String needle)
  {
    if (needle.isEmpty())
      return haystack;
    int[] prev = calcPrev(needle);
    int j = 0;
    for (int i = 0; i < haystack.length(); ++i)
    {
      while (j >= 0 && needle.charAt(j) != haystack.charAt(i))
        j = prev[j];
      ++j;
      if (j == needle.length())
        return haystack.substring(i + 1 - needle.length());
    }
    return null;
  }

}
