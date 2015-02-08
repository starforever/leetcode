public class Solution
{
  public ArrayList<ArrayList<Integer>> permute (int[] num)
  {
    int N = num.length;
    ArrayList<ArrayList<Integer>> solList = new ArrayList<ArrayList<Integer>>();
    if (N == 0)
      return solList;
    boolean[] used = new boolean[N];
    int[] idx = new int[N];
    idx[0] = -1;
    int L = 1;
    while (L > 0)
    {
      int i = idx[L - 1];
      if (i != -1)
        used[i] = false;
      ++i;
      while (i < N && used[i])
        ++i;
      if (i == N)
      {
        --L;
        continue;
      }
      used[i] = true;
      idx[L - 1] = i;
      if (L == N)
      {
        ArrayList<Integer> sol = new ArrayList<Integer>();
        for (int j = 0; j < N; ++j)
          sol.add(num[idx[j]]);
        solList.add(sol);
        continue;
      }
      idx[L++] = -1;
    }
    return solList;
  }
}
