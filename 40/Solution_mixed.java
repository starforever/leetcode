public class Solution
{

  int T;

  int N;
  int[] num;
  int[] count;

  boolean[][] hasSol;

  ArrayList<ArrayList<Integer>> solList;
  Stack<Integer> curSol;

  void calcHasSol ()
  {
    int C = num.length;
    hasSol = new boolean[C + 1][T + 1];
    hasSol[C][0] = true;
    for (int t = 1; t <= T; ++t)
      hasSol[C][t] = false;
    for (int c = C - 1; c >= 0; --c)
    {
      for (int t = 0; t <= T; ++t)
        hasSol[c][t] = hasSol[c + 1][t] || t >= num[c] && hasSol[c + 1][t - num[c]];
    }
  }

  void uniqueCount ()
  {
    count = new int[num.length];
    Arrays.fill(count, 0);
    N = 0;
    int i = 0;
    while (i < num.length)
    {
      num[N] = num[i];
      while (i < num.length && num[i] == num[N])
      {
        ++count[N];
        ++i;
      }
      ++N;
    }
  }

  void search (int idx, int idx0, int remain)
  {
    if (remain == 0)
    {
      solList.add(new ArrayList<Integer>(curSol));
      return;
    }
    if (idx == N)
      return;
    if (!hasSol[idx0][remain])
      return;
    for (int n = 0; n <= count[idx] && num[idx] * n <= remain; ++n)
    {
      search(idx + 1, idx0 + count[idx], remain - num[idx] * n);
      curSol.push(num[idx]);
    }
    while (!curSol.empty() && curSol.peek() == num[idx])
      curSol.pop();
  }

  public ArrayList<ArrayList<Integer>> combinationSum2 (int[] num, int target)
  {
    this.T = target;
    this.num = num;
    Arrays.sort(num);
    calcHasSol();
    uniqueCount();
    solList = new ArrayList<ArrayList<Integer>>();
    curSol = new Stack<Integer>();
    search(0, 0, target);
    return solList;
  }

}
