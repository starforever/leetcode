public class Solution
{

  int N;
  int K;

  int L;
  int[] cur;

  ArrayList<ArrayList<Integer>> numList;

  void search (int n, int k)
  {
    if (k == K)
    {
      ArrayList<Integer> num = new ArrayList<Integer>();
      for (int i = 0; i < L; ++i)
        num.add(cur[i]);
      numList.add(num);
      return;
    }
    if (n > N)
      return;
    search(n + 1, k);
    cur[L++] = n;
    search(n + 1, k + 1);
    --L;
  }

  public ArrayList<ArrayList<Integer>> combine (int n, int k)
  {
    N = n;
    K = k;
    L = 0;
    cur = new int[K];
    numList = new ArrayList<ArrayList<Integer>>();
    search(1, 0);
    return numList;
  }

}
