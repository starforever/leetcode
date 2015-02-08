public class Solution
{

  int N;
  int[] num;

  int[] cur;
  boolean[] used;

  ArrayList<ArrayList<Integer>> solList;

  void search (int idx)
  {
    if (idx == N)
    {
      ArrayList<Integer> sol = new ArrayList<Integer>();
      for (int i = 0; i < N; ++i)
        sol.add(cur[i]);
      solList.add(sol);
      return;
    }
    int i = 0;
    while (i < N)
    {
      int j = i;
      while (j < N && num[j] == num[i] && used[j])
        ++j;
      if (j < N && num[j] == num[i])
      {
        cur[idx] = num[i];
        used[j] = true;
        search(idx + 1);
        used[j] = false;
      }
      while (j < N && num[j] == num[i])
        ++j;
      i = j;
    }
  }

  public ArrayList<ArrayList<Integer>> permuteUnique (int[] num)
  {
    solList = new ArrayList<ArrayList<Integer>>();
    if (num == null || num.length == 0)
      return solList;
    N = num.length;
    this.num = num;
    Arrays.sort(num);
    cur = new int[N];
    used = new boolean[N];
    search(0);
    return solList;
  }

}
