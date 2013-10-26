public class Solution
{

  int N;
  int[] ratings;
  int[] candy;

  boolean[] vis;
  int[] order;
  int orderIdx;

  void DFS (int u)
  {
    if (vis[u])
      return;
    vis[u] = true;
    if (u - 1 >= 0 && ratings[u - 1] > ratings[u])
      DFS(u - 1);
    if (u + 1 < N && ratings[u + 1] > ratings[u])
      DFS(u + 1);
    order[orderIdx--] = u;
  }

  void calcOrder ()
  {
    vis = new boolean[N];
    order = new int[N];
    orderIdx = N - 1;
    for (int i = N - 1; i >= 0; --i)
      DFS(i);
  }

  public int candy (int[] ratings)
  {
    N = ratings.length;
    this.ratings = ratings;
    calcOrder();
    candy = new int[N];
    for (int i = 0; i < N; ++i)
    {
      int p = order[i];
      int c = 0;
      if (p - 1 >= 0 && ratings[p - 1] < ratings[p])
        c = Math.max(c, candy[p - 1]);
      if (p + 1 < N && ratings[p + 1] < ratings[p])
        c = Math.max(c, candy[p + 1]);
      candy[p] = c + 1;
    }
    int sum = 0;
    for (int i = 0; i < N; ++i)
      sum += candy[i];
    return sum;
  }
}
