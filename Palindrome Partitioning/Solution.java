public class Solution
{

  HashMap<String, ArrayList<ArrayList<String>>> memPartition;
  HashMap<String, Boolean> memPalindrome;

  boolean isPalindrome (String str)
  {
    if (str.length() <= 1)
      return true;
    if (memPalindrome.containsKey(str))
      return memPalindrome.get(str);
    int n = str.length();
    boolean ret = str.charAt(0) == str.charAt(n - 1) && isPalindrome(str.substring(1, n - 1));
    memPalindrome.put(str, ret);
    return ret;
  }

  ArrayList<ArrayList<String>> getPartitions (String str)
  {
    if (memPartition.containsKey(str))
      return memPartition.get(str);
    if (str.isEmpty())
    {
      ArrayList<ArrayList<String>> ret = new ArrayList<ArrayList<String>>();
      ret.add(new ArrayList<String>());
      memPartition.put(str, ret);
      return ret;
    }
    ArrayList<ArrayList<String>> ret = new ArrayList<ArrayList<String>>();
    for (int i = 0; i < str.length(); ++i)
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
    memPartition.put(str, ret);
    return ret;
  }

  public ArrayList<ArrayList<String>> partition (String s)
  {
    memPartition = new HashMap<String, ArrayList<ArrayList<String>>>();
    memPalindrome = new HashMap<String, Boolean>();
    return getPartitions(s);
  }
}
