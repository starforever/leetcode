public class Solution
{
  private int N, M;
  private int[][] dungeon;
  private int[][] health;

  public int calculateMinimumHP (int[][] dungeon)
  {
    this.dungeon = dungeon;
    if (dungeon == null)
      throw new IllegalArgumentException();
    N = dungeon.length;
    if (N == 0)
      throw new IllegalArgumentException();
    M = dungeon[0].length;
    if (M == 0)
      throw new IllegalArgumentException();
    health = new int[N][M];
    int lower = 0, upper = Integer.MAX_VALUE;
    while (upper - lower > 1)
    {
      int mid = (lower + upper - 1) / 2;
      if (success(mid))
        upper = mid + 1;
      else
        lower = mid + 1;
    }
    return lower + 1;
  }

  private boolean success (int iniHealth)
  {
    health[0][0] = dungeon[0][0] + iniHealth;
    if (health[0][0] < 0)
      return false;
    for (int j = 1; j < M; ++j)
      health[0][j] = health[0][j - 1] >= 0 ? health[0][j - 1] + dungeon[0][j] : -1;
    for (int i = 1; i < N; ++i)
    {
      health[i][0] = health[i - 1][0] >= 0 ? health[i - 1][0] + dungeon[i][0] : -1;
      for (int j = 1; j < M; ++j)
      {
        int t = Math.max(health[i - 1][j], health[i][j - 1]);
        health[i][j] = t >= 0 ? t + dungeon[i][j] : -1;
      }
    }
    return health[N - 1][M - 1] >= 0;
  }
}
