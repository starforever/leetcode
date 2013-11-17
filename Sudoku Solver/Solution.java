public class Solution
{

  char[][] board;
  boolean[][] rowUsed, colUsed, gridUsed;

  boolean search (int idx)
  {
    if (idx == 81)
      return true;
    int r = idx / 9, c = idx % 9, g = (r / 3) * 3 + (c / 3);
    if (board[r][c] != '.')
      return search(idx + 1);
    for (int x = 0; x < 9; ++x)
      if (!rowUsed[r][x] && !colUsed[c][x] && !gridUsed[g][x])
      {
        board[r][c] = (char)(x + '1');
        rowUsed[r][x] = colUsed[c][x] = gridUsed[g][x] = true;
        if (search(idx + 1))
          return true;
        board[r][c] = '.';
        rowUsed[r][x] = colUsed[c][x] = gridUsed[g][x] = false;
      }
    return false;
  }

  public void solveSudoku (char[][] board)
  {
    this.board = board;
    rowUsed = new boolean[9][9];
    colUsed = new boolean[9][9];
    gridUsed = new boolean[9][9];
    for (int r = 0; r < 9; ++r)
      for (int c = 0; c < 9; ++c)
        if (board[r][c] != '.')
        {
          int x = board[r][c] - '1';
          int g = (r / 3) * 3 + (c / 3);
          rowUsed[r][x] = colUsed[c][x] = gridUsed[g][x] = true;
        }
    search(0);
  }

}
