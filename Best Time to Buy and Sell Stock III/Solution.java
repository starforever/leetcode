public class Solution
{
  public int maxProfit (int[] prices)
  {
    if (prices == null || prices.length <= 1)
      return 0;
    int n = prices.length;
    int maxProfit = 0;
    int maxProfit1 = 0;
    int minPrice1 = prices[0];
    for (int i = 1; i < n; ++i)
    {
      int profit1 = prices[i] - minPrice1;
      minPrice1 = Math.min(minPrice1, prices[i]);
      if (profit1 > maxProfit1)
      {
        maxProfit1 = profit1;
        int maxProfit2 = 0;
        int minPrice2 = prices[i];
        for (int j = i + 1; j < n; ++j)
        {
          int profit2 = prices[j] - minPrice2;
          minPrice2 = Math.min(minPrice2, prices[j]);
          maxProfit2 = Math.max(maxProfit2, profit2);
        }
        maxProfit = Math.max(maxProfit, maxProfit1 + maxProfit2);
      }
    }
    return maxProfit;
  }
}
