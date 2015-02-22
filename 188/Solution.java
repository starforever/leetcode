public class Solution
{
  public int maxProfit (int K, int[] prices)
  {
    int N = prices.length;
    K = Math.min(K, N / 2);
    int[][] gain = new int[N + 1][K + 1];
    for (int i = 0; i <= N; ++i)
      gain[i][K] = 0;
    for (int k = K - 1; k >= 0; --k)
    {
      gain[N - 1][k] = gain[N][k] = 0;
      int opt = prices[N - 1];
      for (int i = N - 2; i >= 0; --i)
      {
        gain[i][k] = Math.max(gain[i + 1][k], opt - prices[i]);
        opt = Math.max(opt, prices[i] + gain[i + 1][k + 1]);
      }
    }
    return gain[0][0];
  }
}
