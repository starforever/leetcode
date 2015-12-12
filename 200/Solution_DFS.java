public class Solution
{
  private int N, M;
  private char[][] grid;

  private void fill (int x, int y)
  {
    if (x < 0 || x >= N || y < 0 || y >= M)
      return;
    if (grid[x][y] != '1')
      return;
    grid[x][y] = 'x';
    fill(x + 1, y);
    fill(x - 1, y);
    fill(x, y + 1);
    fill(x, y - 1);
  }

  public int numIslands (char[][] grid)
  {
    if (grid == null)
      throw new IllegalArgumentException();
    N = grid.length;
    if (N == 0)
      return 0;
    M = grid[0].length;
    if (M == 0)
      return 0;
    this.grid = grid;
    int cnt = 0;
    for (int x = 0; x < N; ++x)
      for (int y = 0; y < M; ++y)
      {
        if (grid[x][y] == '1')
        {
          fill(x, y);
          ++cnt;
        }
      }
    return cnt;
  }
}
