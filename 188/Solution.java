public class Solution
{
  public int maxProfit (int K, int[] prices)
  {
    int N = prices.length;
    K = Math.min(K, N / 2);
    int[][] gain = new int[N + 1][K + 1];
    for (int j = 0; j <= K; ++j)
      gain[N][j] = 0;
    for (int i = N - 1; i >= 0; --i)
    {
      gain[i][K] = 0;
      for (int j = K - 1; j >= 0; --j)
      {
        gain[i][j] = gain[i + 1][j];
        for (int k = i + 1; k < N; ++k)
          gain[i][j] = Math.max(gain[i][j], prices[k] - prices[i] + gain[k + 1][j + 1]);
      }
    }
    return gain[0][0];
  }
}
