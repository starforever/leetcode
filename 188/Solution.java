public class Solution
{
  public int maxProfit (int K, int[] prices)
  {
    int sol = quickSolve(K, prices);
    if (sol != -1)
      return sol;
    int N = prices.length;
    int[] gainCurrent = new int[N + 1];
    int[] gainNext = new int[N + 1];
    for (int i = 0; i <= N; ++i)
      gainCurrent[i] = 0;
    for (int k = K - 1; k >= 0; --k)
    {
      int[] tmp = gainCurrent;
      gainCurrent = gainNext;
      gainNext = tmp;

      gainCurrent[N - 1] = gainCurrent[N] = 0;
      int opt = prices[N - 1];
      for (int i = N - 2; i >= 0; --i)
      {
        gainCurrent[i] = Math.max(gainCurrent[i + 1], opt - prices[i]);
        opt = Math.max(opt, prices[i] + gainNext[i + 1]);
      }
    }
    return gainCurrent[0];
  }

  private int quickSolve (int K, int[] prices)
  {
    int N = prices.length;
    int i = 0;
    int numRise = 0;
    int totalGain = 0;
    while (i + 1 < N)
    {
      while (i + 1 < N && prices[i + 1] < prices[i])
        ++i;
      if (i + 1 >= N)
        break;
      ++numRise;
      int j = i;
      while (i + 1 < N && prices[i + 1] >= prices[i])
        ++i;
      totalGain += prices[i] - prices[j];
    }
    return numRise <= K ? totalGain : -1;
  }
}
