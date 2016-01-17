public class Solution
{
  LinkedList<Integer> cur = new LinkedList<Integer>();
  List<List<Integer>> solList = new ArrayList<List<Integer>>();

  private void search (int num, int cnt, int sum)
  {
    if (num > 9)
    {
      if (cnt == 0 && sum == 0)
        solList.add(new ArrayList<Integer>(cur));
      return;
    }
    search(num + 1, cnt, sum);
    cur.add(num);
    search(num + 1, cnt - 1, sum - num);
    cur.removeLast();
  }

  public List<List<Integer>> combinationSum3 (int k, int n)
  {
    search(1, k, n);
    return solList;
  }
}
