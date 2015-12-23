class TrieNode
{
  private boolean end = false;
  private TrieNode[] next;

  public TrieNode ()
  {
    end = false;
    next = new TrieNode[26];
  }

  public void setEnd ()
  {
    end = true;
  }

  public boolean getEnd ()
  {
    return end;
  }

  public void setNext (char c)
  {
    next[c - 'a'] = new TrieNode();
  }

  public TrieNode getNext (char c)
  {
    return next[c - 'a'];
  }
}

public class Trie
{
  private TrieNode root;

  public Trie ()
  {
    root = new TrieNode();
  }

  public void insert (String word)
  {
    TrieNode p = root;
    for (int i = 0; i < word.length(); ++i)
    {
      char c = word.charAt(i);
      if (p.getNext(c) == null)
        p.setNext(c);
      p = p.getNext(c);
    }
    p.setEnd();
  }

  private TrieNode find (String word)
  {
    TrieNode p = root;
    for (int i = 0; i < word.length(); ++i)
    {
      char c = word.charAt(i);
      if (p.getNext(c) == null)
        return null;
      p = p.getNext(c);
    }
    return p;
  }

  public boolean search (String word)
  {
    TrieNode p = find(word);
    return p != null && p.getEnd();
  }

  public boolean startsWith (String prefix)
  {
    TrieNode p = find(prefix);
    return p != null;
  }
}
