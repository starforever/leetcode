public class Solution
{

  int N;
  int[] num;
  int[] count;

  ArrayList<ArrayList<Integer>> solList;
  Stack<Integer> curSol;

  void uniqueCount ()
  {
    Arrays.sort(num);
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

  public ArrayList<ArrayList<Integer>> combinationSum2 (int[] num, int target)
  {
    this.num = num;
    count = new int[num.length];
    uniqueCount();
    solList = new ArrayList<ArrayList<Integer>>();
    curSol = new Stack<Integer>();
    search(0, target);
    return solList;
  }

}
