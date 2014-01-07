public class Solution
{

  int C, T;
  int[] num;

  boolean[][] hasSol;

  HashSet<ArrayList<Integer>> findSol (int c, int t)
  {
    HashSet<ArrayList<Integer>> ret = new HashSet<ArrayList<Integer>>();
    if (t < 0 || !hasSol[c][t])
      return ret;
    if (c == 0 && t == 0)
    {
      ret.add(new ArrayList<Integer>());
      return ret;
    }
    for (ArrayList<Integer> sol : findSol(c - 1, t))
      ret.add(sol);
    for (ArrayList<Integer> sol : findSol(c - 1, t - num[c - 1]))
    {
      sol.add(num[c - 1]);
      ret.add(sol);
    }
    return ret;
  }

  public ArrayList<ArrayList<Integer>> combinationSum2 (int[] num, int target)
  {
    if (num == null)
      num = new int[0];
    this.num = num;
    C = num.length;
    T = target;
    Arrays.sort(num);
    hasSol = new boolean[C + 1][T + 1];
    hasSol[0][0] = true;
    for (int t = 1; t <= T; ++t)
      hasSol[0][t] = false;
    for (int c = 1; c <= C; ++c)
    {
      for (int t = 0; t <= T; ++t)
        hasSol[c][t] = hasSol[c - 1][t] || t >= num[c - 1] && hasSol[c - 1][t - num[c - 1]];
    }
    ArrayList<ArrayList<Integer>> solList = new ArrayList<ArrayList<Integer>>();
    for (ArrayList<Integer> sol : findSol(C, T))
      solList.add(sol);
    return solList;
  }

}
