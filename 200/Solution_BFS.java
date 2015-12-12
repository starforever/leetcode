public class Solution
{
  private final int[] dx = new int[]{1, 0, -1, 0};
  private final int[] dy = new int[]{0, 1, 0, -1};

  private int N, M;
  private char[][] grid;

  private class Coor
  {
    int x, y;

    public Coor (int x, int y)
    {
      this.x = x;
      this.y = y;
    }
  }

  private void fill (int x0, int y0)
  {
    LinkedList<Coor> queue = new LinkedList<Coor>();
    queue.add(new Coor(x0, y0));
    grid[x0][y0] = 'x';
    while (!queue.isEmpty())
    {
      Coor u = queue.removeFirst();
      for (int d = 0; d < 4; ++d)
      {
        Coor v = new Coor(u.x + dx[d], u.y + dy[d]);
        if (v.x >= 0 && v.x < N && v.y >= 0 && v.y < M && grid[v.x][v.y] == '1')
        {
          grid[v.x][v.y] = 'x';
          queue.add(v);
        }
      }
    }
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
