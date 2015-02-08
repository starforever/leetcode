public class Solution
{
  public boolean isValidSudoku (char[][] board)
  {
    boolean[][] rowUsed = new boolean[9][9];
    boolean[][] colUsed = new boolean[9][9];
    boolean[][] gridUsed = new boolean[9][9];
    for (int r = 0; r < 9; ++r)
      for (int c = 0; c < 9; ++c)
        if (board[r][c] != '.')
        {
          int g = (r / 3) * 3 + (c / 3);
          int x = board[r][c] - '1';
          if (rowUsed[r][x] || colUsed[c][x] || gridUsed[g][x])
            return false;
          rowUsed[r][x] = colUsed[c][x] = gridUsed[g][x] = true;
        }
    return true;
  }
}
