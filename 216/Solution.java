public class Solution
{
  LinkedList<Integer> cur = new LinkedList<Integer>();
  List<List<Integer>> solList = new ArrayList<List<Integer>>();

  private void search (int start, int cnt, int sum)
  {
    if (cnt == 0 && sum == 0)
    {
      solList.add(new ArrayList<Integer>(cur));
      return;
    }
    if (10 - start < cnt)
      return;
    if ((start + start + cnt - 1) * cnt / 2 > sum)
      return;
    if ((9 + 9 - cnt + 1) * cnt / 2 < sum)
      return;
    for (int num = start; num <= 9; ++num)
    {
      cur.add(num);
      search(num + 1, cnt - 1, sum - num);
      cur.removeLast();
    }
  }

  public List<List<Integer>> combinationSum3 (int k, int n)
  {
    search(1, k, n);
    return solList;
  }
}
