public class Solution
{

  String[] strs;

  boolean hasSameCharacterAt (int i)
  {
    if (i >= strs[0].length())
      return false;
    char c = strs[0].charAt(i);
    for (int j = 1; j < strs.length; ++j)
    {
      if (i >= strs[j].length() || strs[j].charAt(i) != c)
        return false;
    }
    return true;
  }

  public String longestCommonPrefix (String[] strs)
  {
    if (strs == null || strs.length == 0)
      return "";
    this.strs = strs;
    int i = 0;
    while (hasSameCharacterAt(i))
      ++i;
    return strs[0].substring(0, i);
  }

}
