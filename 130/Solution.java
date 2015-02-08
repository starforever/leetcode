public class Solution
{

  static final int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};

  int N, M;
  char[][] board;

  int slot[][];

  void capture (int x0, int y0)
  {
    int f = 0, e = 1;
    slot[0][0] = x0;
    slot[0][1] = y0;
    board[x0][y0] = '*';
    boolean captured = true;
    while (f < e)
    {
      int cx = slot[f][0], cy = slot[f][1];
      for (int d = 0; d < 4; ++d)
      {
        int tx = cx + dx[d], ty = cy + dy[d];
        if (tx >= 0 && tx < N && ty >= 0 && ty < M)
        {
          if (board[tx][ty] == 'O')
          {
            board[tx][ty] = '*';
            slot[e][0] = tx;
            slot[e][1] = ty;
            ++e;
          }
        }
        else
          captured = false;
      }
      ++f;
    }
    if (captured)
    {
      for (int i = 0; i < e; ++i)
      {
        int cx = slot[i][0], cy = slot[i][1];
        board[cx][cy] = 'X';
      }
    }
  }

  public void solve (char[][] board)
  {
    if (board == null || board.length == 0 || board[0].length == 0)
      return;
    N = board.length;
    M = board[0].length;
    this.board = board;
    slot = new int[N * M][2];
    for (int x = 0; x < N; ++x)
      for (int y = 0; y < M; ++y)
        if (board[x][y] == 'O')
          capture(x, y);
    for (int x = 0; x < N; ++x)
      for (int y = 0; y < M; ++y)
        if (board[x][y] == '*')
          board[x][y] = 'O';
  }

}
