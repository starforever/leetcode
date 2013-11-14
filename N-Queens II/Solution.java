public class Solution
{

  int N;
  int numSol;

  boolean[] usedRow;
  boolean[] usedDiag1;
  boolean[] usedDiag2;

  void search (int col)
  {
    if (col == N)
    {
      ++numSol;
      return;
    }
    for (int row = 0; row < N; ++row)
      if (!usedRow[row] && !usedDiag1[row + col] && !usedDiag2[col - row + N - 1])
      {
        usedRow[row] = usedDiag1[row + col] = usedDiag2[col - row + N - 1] = true;
        search(col + 1);
        usedRow[row] = usedDiag1[row + col] = usedDiag2[col - row + N - 1] = false;
      }
  }

  public int totalNQueens (int n)
  {
    N = n;
    if (N == 0)
      return 0;
    usedRow = new boolean[N];
    usedDiag1 = new boolean[2 * N - 1];
    usedDiag2 = new boolean[2 * N - 1];
    numSol = 0;
    search(0);
    return numSol;
  }

}
