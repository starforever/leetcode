class TrieNode
{
  int idx = -1;
  TrieNode[] next = new TrieNode[26];
}

public class Solution
{
  static final int[] dx = {1, 0, -1, 0};
  static final int[] dy = {0, 1, 0, -1};

  int X, Y;
  char[][] board;
  boolean[][] vis;
  boolean[] exist;

  private TrieNode buildTrie (String[] words)
  {
    TrieNode root = new TrieNode();
    for (int i = 0; i < words.length; ++i)
    {
      TrieNode p = root;
      for (int j = 0; j < words[i].length(); ++j)
      {
        char c = words[i].charAt(j);
        if (p.next[c - 'a'] == null)
          p.next[c - 'a'] = new TrieNode();
        p = p.next[c - 'a'];
      }
      p.idx = i;
    }
    return root;
  }

  private void search (int x, int y, TrieNode p)
  {
    if (p.idx != -1)
      exist[p.idx] = true;

    for (int d = 0; d < 4; ++d)
    {
      int x2 = x + dx[d], y2 = y + dy[d];
      if (x2 >= 0 && x2 < X && y2 >= 0 && y2 < Y && !vis[x2][y2] && p.next[board[x2][y2] - 'a'] != null)
      {
        vis[x2][y2] = true;
        search(x2, y2, p.next[board[x2][y2] - 'a']);
        vis[x2][y2] = false;
      }
    }
  }

  public List<String> findWords (char[][] board, String[] words)
  {
    if (board == null || board.length == 0)
      throw new IllegalArgumentException();
    for (int x = 0; x < board.length; ++x)
    {
      if (board[x] == null || board[x].length == 0 || board[x].length != board[0].length)
        throw new IllegalArgumentException();
    }
    if (words == null)
      throw new IllegalArgumentException();
    for (String s : words)
    {
      if (s == null || s.isEmpty())
        throw new IllegalArgumentException();
    }

    TrieNode root = buildTrie(words);

    X = board.length;
    Y = board[0].length;
    this.board = board;
    vis = new boolean[X][Y];
    for (int x = 0; x < X; ++x)
      for (int y = 0; y < Y; ++y)
        vis[x][y] = false;
    exist = new boolean[words.length];
    for (int i = 0; i < words.length; ++i)
      exist[i] = false;

    for (int x = 0; x < X; ++x)
      for (int y = 0; y < Y; ++y)
      {
        if (root.next[board[x][y] - 'a'] != null)
        {
          vis[x][y] = true;
          search(x, y, root.next[board[x][y] - 'a']);
          vis[x][y] = false;
        }
      }

    List<String> ret = new LinkedList<String>();
    for (int i = 0; i < words.length; ++i)
    {
      if (exist[i])
        ret.add(words[i]);
    }
    return ret;
  }
}
