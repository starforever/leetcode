public class Solution
{

  static class Node
  {
    boolean finish = false;
    HashMap<Character, Node> next = new HashMap<Character, Node>();
  }

  Node buildTrie (Set<String> dict)
  {
    Node root = new Node();
    for (String word : dict)
    {
      Node p = root;
      for (int i = 0; i < word.length(); ++i)
      {
        char c = word.charAt(i);
        if (!p.next.containsKey(c))
          p.next.put(c, new Node());
        p = p.next.get(c);
      }
      p.finish = true;
    }
    return root;
  }

  boolean[] calcCanBreak (String s, Node trie)
  {
    boolean[] canBreak = new boolean[s.length() + 1];
    canBreak[s.length()] = true;
    for (int i = s.length() - 1; i >= 0; --i)
    {
      canBreak[i] = false;
      Node p = trie;
      for (int j = i; j < s.length(); ++j)
      {
        char c = s.charAt(j);
        if (p.next.containsKey(c))
          p = p.next.get(c);
        else
          break;
        if (p.finish && canBreak[j + 1])
        {
          canBreak[i] = true;
          break;
        }
      }
    }
    return canBreak;
  }

  public boolean wordBreak (String s, Set<String> dict)
  {
    Node trie = buildTrie(dict);
    boolean[] canBreak = calcCanBreak(s, trie);
    return canBreak[0];
  }

}
