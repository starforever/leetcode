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

  ArrayList<String>[] calcSentenceList (String str, Node trie)
  {
    ArrayList<String>[] senLst = new ArrayList[str.length() + 1];
    senLst[str.length()] = new ArrayList<String>();
    senLst[str.length()].add("");
    for (int i = str.length() - 1; i >= 0; --i)
    {
      senLst[i] = new ArrayList<String>();
      Node p = trie;
      for (int j = i; j < str.length(); ++j)
      {
        char c = str.charAt(j);
        if (p.next.containsKey(c))
          p = p.next.get(c);
        else
          break;
        if (p.finish)
        {
          String word = str.substring(i, j + 1);
          for (String sub : senLst[j + 1])
          {
            if (sub.isEmpty())
              senLst[i].add(word);
            else
              senLst[i].add(word + " " + sub);
          }
        }
      }
    }
    return senLst;
  }

  public ArrayList<String> wordBreak (String s, Set<String> dict)
  {
    Node trie = buildTrie(dict);
    ArrayList<String>[] sentenceList = calcSentenceList(s, trie);
    return sentenceList[0];
  }

}
