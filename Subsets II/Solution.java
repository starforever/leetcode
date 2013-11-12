public class Solution
{

  int N;
  int[] num;

  int L;
  int[] cur;

  HashSet<ArrayList<Integer>> subSet;

  void search (int idx)
  {
    if (idx == N)
    {
      ArrayList<Integer> sub = new ArrayList<Integer>();
      for (int i = 0; i < L; ++i)
        sub.add(cur[i]);
      subSet.add(sub);
      return;
    }
    search(idx + 1);
    cur[L++] = num[idx];
    search(idx + 1);
    --L;
  }

  public ArrayList<ArrayList<Integer>> subsetsWithDup (int[] num)
  {
    N = num.length;
    this.num = num;
    Arrays.sort(num);
    cur = new int[N];
    L = 0;
    subSet = new HashSet<ArrayList<Integer>>();
    search(0);
    ArrayList<ArrayList<Integer>> subList = new ArrayList<ArrayList<Integer>>();
    for (ArrayList<Integer> sub : subSet)
      subList.add(sub);
    return subList;
  }

}
