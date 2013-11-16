public class Solution
{
  public ArrayList<ArrayList<Integer>> combinationSum2 (int[] num, int target)
  {
    if (num == null)
      num = new int[0];
    int C = num.length, T = target;
    Arrays.sort(num);
    ArrayList<ArrayList<Integer>>[][] sumSol = new ArrayList[C + 1][T + 1];
    for (int t = 0; t <= T; ++t)
      sumSol[0][t] = new ArrayList<ArrayList<Integer>>();
    sumSol[0][0].add(new ArrayList<Integer>());
    for (int c = 1; c <= C; ++c)
    {
      for (int t = 0; t <= T; ++t)
      {
        sumSol[c][t] = new ArrayList<ArrayList<Integer>>();
        for (ArrayList<Integer> sol : sumSol[c - 1][t])
          sumSol[c][t].add(new ArrayList<Integer>(sol));
        if (t >= num[c - 1])
        {
          for (ArrayList<Integer> sol : sumSol[c - 1][t - num[c - 1]])
          {
            ArrayList<Integer> tmp = new ArrayList<Integer>(sol);
            tmp.add(num[c - 1]);
            sumSol[c][t].add(tmp);
          }
        }
      }
    }
    return sumSol[C][T];
  }
}
