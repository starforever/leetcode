import java.util.*;

public class Solution
{

  ArrayList<Integer> getCharFreq (String str)
  {
    int[] freq = new int[26];
    for (int i = 0; i < str.length(); ++i)
      ++freq[str.charAt(i) - 'a'];
    ArrayList<Integer> ret = new ArrayList<Integer>();
    for (int i = 0; i < 26; ++i)
      ret.add(freq[i]);
    return ret;
  }

  String getMinString (String str)
  {
    ArrayList<Integer> freq = getCharFreq(str);
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < 26; ++i)
      for (int j = 0; j < freq.get(i); ++j)
        sb.append((char)('a' + i));
    return sb.toString();
  }

  public ArrayList<String> anagrams (String[] strs)
  {
    HashMap<String, ArrayList<String>> groupTable = new HashMap<String, ArrayList<String>>();
    for (int i = 0; i < strs.length; ++i)
    {
      String key = getMinString(strs[i]);
      if (!groupTable.containsKey(key))
        groupTable.put(key, new ArrayList<String>());
      groupTable.get(key).add(strs[i]);
    }
    ArrayList<String> ret = new ArrayList<String>();
    for (ArrayList<String> group : groupTable.values())
      if (group.size() > 1)
        ret.addAll(group);
    return ret;
  }

  public static void main (String[] args)
  {
    Solution sol = new Solution();
    for (String str : sol.anagrams(new String[]{"aabbccdd", "abcdabcd", "ace", "bbccaadd", "aec"}))
      System.out.println(str);
  }

}
