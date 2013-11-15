public class Solution
{

  int N;
  int[] num;

  ArrayList<ArrayList<Integer>> solList;

  int[] cur;
  boolean[] used;

  void search (int idx)
  {
    if (idx == N)
    {
      ArrayList<Integer> sol = new ArrayList<Integer>();
      for (int i = 0; i < N; ++i)
        sol.add(num[cur[i]]);
      solList.add(sol);
      return;
    }
    for (int i = 0; i < N; ++i)
      if (!used[i])
      {
        cur[idx] = i;
        used[i] = true;
        search(idx + 1);
        used[i] = false;
      }
  }

  public ArrayList<ArrayList<Integer>> permute (int[] num)
  {
    N = num.length;
    solList = new ArrayList<ArrayList<Integer>>();
    if (N == 0)
      return solList;
    this.num = num;
    cur = new int[N];
    used = new boolean[N];
    search(0);
    return solList;
  }

}
