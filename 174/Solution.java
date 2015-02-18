public class Solution
{
  public int calculateMinimumHP (int[][] dungeon)
  {
    if (dungeon == null)
      throw new IllegalArgumentException();
    int N = dungeon.length;
    if (N == 0)
      throw new IllegalArgumentException();
    int M = dungeon[0].length;
    if (M == 0)
      throw new IllegalArgumentException();
    int[][] health = new int[N][M];
    health[0][0] = dungeon[0][0];
    for (int j = 1; j < M; ++j)
      health[0][j] = health[0][j - 1] + dungeon[0][j];
    for (int i = 1; i < N; ++i)
    {
      health[i][0] = health[i - 1][0] + dungeon[i][0];
      for (int j = 1; j < M; ++j)
        health[i][j] = Math.max(health[i - 1][j], health[i][j - 1]) + dungeon[i][j];
    }
    int target = health[N - 1][M - 1];
    if (target >= 0)
      return 1;
    else
      return -target + 1;
  }
}
