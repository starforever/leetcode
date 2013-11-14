public class Solution
{

  int N;
  int[] sol;
  ArrayList<String[]> solList;

  boolean[] usedRow;
  boolean[] usedDiag1;
  boolean[] usedDiag2;

  void search (int col)
  {
    if (col == N)
    {
      String[] sol2 = new String[N];
      for (int i = 0; i < N; ++i)
      {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < N; ++j)
          sb.append(j != sol[i] ? '.' : 'Q');
        sol2[i] = sb.toString();
      }
      solList.add(sol2);
      return;
    }
    for (int row = 0; row < N; ++row)
      if (!usedRow[row] && !usedDiag1[row + col] && !usedDiag2[col - row + N - 1])
      {
        usedRow[row] = usedDiag1[row + col] = usedDiag2[col - row + N - 1] = true;
        sol[col] = row;
        search(col + 1);
        usedRow[row] = usedDiag1[row + col] = usedDiag2[col - row + N - 1] = false;
      }
  }

  public ArrayList<String[]> solveNQueens (int n)
  {
    N = n;
    solList = new ArrayList<String[]>();
    if (N == 0)
      return solList;
    sol = new int[N];
    usedRow = new boolean[N];
    usedDiag1 = new boolean[2 * N - 1];
    usedDiag2 = new boolean[2 * N - 1];
    search(0);
    return solList;
  }

}
