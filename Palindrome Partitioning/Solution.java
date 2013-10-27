public class Solution
{

  HashMap<String, ArrayList<ArrayList<String>>> mem;

  boolean isPalindrome (String str)
  {
    int n = str.length();
    for (int i = 0; i < n / 2; ++i)
      if (str.charAt(i) != str.charAt(n - 1 - i))
        return false;
    return true;
  }

  ArrayList<ArrayList<String>> getPartitions (String str)
  {
    if (mem.containsKey(str))
      return mem.get(str);
    ArrayList<ArrayList<String>> ret = new ArrayList<ArrayList<String>>();
    if (isPalindrome(str))
    {
      ArrayList<String> sol = new ArrayList<String>();
      sol.add(str);
      ret.add(sol);
    }
    for (int i = 1; i < str.length(); ++i)
    {
      String part1 = str.substring(0, i), part2 = str.substring(i);
      if (isPalindrome(part2))
      {
        for (ArrayList<String> solSub : getPartitions(part1))
        {
          ArrayList<String> sol = new ArrayList<String>(solSub);
          sol.add(part2);
          ret.add(sol);
        }
      }
    }
    mem.put(str, ret);
    return ret;
  }

  public ArrayList<ArrayList<String>> partition (String s)
  {
    mem = new HashMap<String, ArrayList<ArrayList<String>>>();
    return getPartitions(s);
  }
}
