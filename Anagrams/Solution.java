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

  public ArrayList<String> anagrams (String[] strs)
  {
    HashMap<ArrayList<Integer>, ArrayList<String>> groupTable = new HashMap<ArrayList<Integer>, ArrayList<String>>();
    for (int i = 0; i < strs.length; ++i)
    {
      ArrayList<Integer> key = getCharFreq(strs[i]);
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

}
