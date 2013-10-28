public class Solution
{
  public int maxProfit (int[] prices)
  {
    if (prices == null || prices.length <= 1)
      return 0;
    int n = prices.length;

    int[] prev = new int[n];
    int valley = prices[0];
    prev[0] = 0;
    for (int i = 1; i < n; ++i)
    {
      valley = Math.min(valley, prices[i]);
      prev[i] = Math.max(prices[i] - valley, prev[i - 1]);
    }

    int[] next = new int[n];
    int peak = prices[n - 1];
    next[n - 1] = 0;
    for (int i = n - 2; i >= 0; --i)
    {
      peak = Math.max(peak, prices[i]);
      next[i] = Math.max(peak - prices[i], next[i + 1]);
    }

    int maxProfit = 0;
    for (int i = 0; i < n; ++i)
      maxProfit = Math.max(maxProfit, prev[i] + next[i]);
    return maxProfit;
  }
}
