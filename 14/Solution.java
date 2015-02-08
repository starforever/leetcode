public class Solution
{

  boolean hasSameCharacterAt (String[] strs, int pos)
  {
    if (pos >= strs[0].length())
      return false;
    char c = strs[0].charAt(pos);
    for (int i = 1; i < strs.length; ++i)
    {
      if (pos >= strs[i].length() || strs[i].charAt(pos) != c)
        return false;
    }
    return true;
  }

  public String longestCommonPrefix (String[] strs)
  {
    if (strs.length == 0)
      return "";
    int pos = 0;
    while (hasSameCharacterAt(strs, pos))
      ++pos;
    return strs[0].substring(0, pos);
  }

}
