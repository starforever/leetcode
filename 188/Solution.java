public class Solution
{
  public int maxProfit (int K, int[] prices)
  {
    int N = prices.length;
    ArrayList<Integer> gains = new ArrayList<Integer>();
    int i = 0;
    while (i + 1 < N)
    {
      while (i + 1 < N && prices[i + 1] <= prices[i])
        ++i;
      int j = i;
      while (i + 1 < N && prices[i + 1] > prices[i])
        ++i;
      gains.add(prices[i] - prices[j]);
    }
    Collections.sort(gains);
    int totalGain = 0;
    for (i = gains.size() - 1; i >= 0 && i >= gains.size() - K; --i)
      totalGain += gains.get(i);
    return totalGain;
  }
}
