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
    int[][] minHealth = new int[N][M];
    minHealth[N - 1][M - 1] = Math.max(-dungeon[N - 1][M - 1], 0);
    for (int j = M - 2; j >= 0; --j)
      minHealth[N - 1][j] = Math.max(minHealth[N - 1][j + 1] - dungeon[N - 1][j], 0);
    for (int i = N - 2; i >= 0; --i)
    {
      minHealth[i][M - 1] = Math.max(minHealth[i + 1][M - 1] - dungeon[i][M - 1], 0);
      for (int j = M - 2; j >= 0; --j)
        minHealth[i][j] = Math.max(Math.min(minHealth[i + 1][j], minHealth[i][j + 1]) - dungeon[i][j], 0);
    }
    return minHealth[0][0] + 1;
  }
}
