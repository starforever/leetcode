public class Solution
{
  public int maxProfit (int K, int[] prices)
  {
    int N = prices.length;
    K = Math.min(K, numRise(prices));
    int[][] gain = new int[N + 1][K + 1];
    for (int i = 0; i <= N; ++i)
      gain[i][K] = 0;
    for (int k = K - 1; k >= 0; --k)
    {
      gain[N - 1][k] = gain[N][k] = 0;
      int opt = prices[N - 1];
      for (int i = N - 2; i >= 0; --i)
      {
        gain[i][k] = gain[i + 1][k];
        if (opt - prices[i] > gain[i][k])
          gain[i][k] = opt - prices[i];
        if (prices[i] + gain[i + 1][k + 1] > opt)
          opt = prices[i] + gain[i + 1][k + 1];
      }
    }
    return gain[0][0];
  }

  private int numRise (int[] prices)
  {
    int N = prices.length;
    int i = 0;
    int cnt = 0;
    while (i + 1 < N)
    {
      while (i + 1 < N && prices[i + 1] < prices[i])
        ++i;
      if (i + 1 >= N)
        break;
      ++cnt;
      while (i + 1 < N && prices[i + 1] >= prices[i])
        ++i;
    }
    return cnt;
  }
}
