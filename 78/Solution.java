public class Solution
{

  int N;
  int[] S;

  int L;
  int[] cur;

  ArrayList<ArrayList<Integer>> subList;

  void search (int idx)
  {
    if (idx == N)
    {
      ArrayList<Integer> sub = new ArrayList<Integer>();
      for (int i = 0; i < L; ++i)
        sub.add(cur[i]);
      subList.add(sub);
      return;
    }
    search(idx + 1);
    cur[L++] = S[idx];
    search(idx + 1);
    --L;
  }

  public ArrayList<ArrayList<Integer>> subsets (int[] S)
  {
    N = S.length;
    this.S = S;
    Arrays.sort(S);
    cur = new int[N];
    L = 0;
    subList = new ArrayList<ArrayList<Integer>>();
    search(0);
    return subList;
  }

}
