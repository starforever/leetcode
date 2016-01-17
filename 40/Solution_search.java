public class Solution
{

  int N;
  int[] num;
  int[] count;

  List<List<Integer>> solList;
  Stack<Integer> curSol;

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

  void search (int idx, int remain)
  {
    if (remain == 0)
    {
      solList.add(new ArrayList<Integer>(curSol));
      return;
    }
    if (idx == N)
      return;
    for (int n = 0; n <= count[idx] && num[idx] * n <= remain; ++n)
    {
      search(idx + 1, remain - num[idx] * n);
      curSol.push(num[idx]);
    }
    while (!curSol.empty() && curSol.peek() == num[idx])
      curSol.pop();
  }

  public List<List<Integer>> combinationSum2 (int[] candidates, int target)
  {
    this.num = candidates;
    Arrays.sort(num);
    uniqueCount();
    solList = new ArrayList<List<Integer>>();
    curSol = new Stack<Integer>();
    search(0, target);
    return solList;
  }

}
