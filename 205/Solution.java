public class Solution
{
  public boolean isIsomorphic (String s, String t)
  {
    if (s == null || t == null)
      throw new IllegalArgumentException();
    if (s.length() != t.length())
      return false;
    HashMap<Character, Character> charMap = new HashMap<Character, Character>();
    HashSet<Character> mapped = new HashSet<Character>();
    for (int i = 0; i < s.length(); ++i)
    {
      char a = s.charAt(i), b = t.charAt(i);
      if (!charMap.containsKey(a))
      {
        if (mapped.contains(b))
          return false;
        else
        {
          charMap.put(a, b);
          mapped.add(b);
        }
      }
      else if (charMap.get(a) != b)
        return false;
    }
    return true;
  }
}
