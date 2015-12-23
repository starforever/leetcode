class TrieNode
{
  boolean finish = false;
  TrieNode[] next = new TrieNode[26];
}

public class WordDictionary
{
  private TrieNode root = new TrieNode();

  public void addWord (String word)
  {
    if (word == null)
      throw new IllegalArgumentException();
    TrieNode p = root;
    for (int i = 0; i < word.length(); ++i)
    {
      char c = word.charAt(i);
      if (p.next[c - 'a'] == null)
        p.next[c - 'a'] = new TrieNode();
      p = p.next[c - 'a'];
    }
    p.finish = true;
  }

  private boolean match (TrieNode cur, int idx, String word)
  {
    if (idx == word.length())
      return cur.finish;
    char c = word.charAt(idx);
    if (c == '.')
    {
      for (int i = 0; i < 26; ++i)
      {
        if (cur.next[i] != null && match(cur.next[i], idx + 1, word))
          return true;
      }
      return false;
    }
    else
    {
      TrieNode p = cur.next[c - 'a'];
      if (p == null)
        return false;
      return match(p, idx + 1, word);
    }
  }

  public boolean search (String word)
  {
    if (word == null)
      throw new IllegalArgumentException();
    return match(root, 0, word);
  }
}
