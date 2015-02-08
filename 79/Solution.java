public class Solution
{

  int N, M, W;
  char[][] board;
  char[] word;

  boolean[][] vis;

  static int[] dx = {1, 0, -1, 0};
  static int[] dy = {0, 1, 0, -1};

  boolean search (int x, int y, int p)
  {
    if (p == W)
      return true;
    if (!(x >= 0 && x < M && y >= 0 && y < N))
      return false;
    if (board[y][x] != word[p])
      return false;
    if (vis[y][x])
      return false;
    vis[y][x] = true;
    for (int d = 0; d < 4; ++d)
    {
      int x2 = x + dx[d], y2 = y + dy[d];
      if (search(x2, y2, p + 1))
        return true;
    }
    vis[y][x] = false;
    return false;
  }

  public boolean exist (char[][] board, String word)
  {
    if (word == null || word.isEmpty())
      return true;
    if (board == null || board.length == 0 || board[0].length == 0)
      return false;
    N = board.length;
    M = board[0].length;
    W = word.length();
    this.board = board;
    this.word = word.toCharArray();
    vis = new boolean[N][M];
    for (int y = 0; y < N; ++y)
      for (int x = 0; x < M; ++x)
        if (search(x, y, 0))
          return true;
    return false;
  }
}
