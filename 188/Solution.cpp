#include <vector>
#include <algorithm>
using namespace std;

#define min2(x, y) ((x) < (y) ? (x) : (y))
#define max2(x, y) ((x) > (y) ? (x) : (y))

class Solution
{
public:
  int maxProfit (int K, vector<int> &prices)
  {
    int N = prices.size();
    K = min2(K, numRise(prices));
    int *gainCurr = new int[N + 1];
    int *gainNext = new int[N + 1];
    for (int i = 0; i <= N; ++i)
      gainCurr[i] = 0;
    for (int k = K - 1; k >= 0; --k)
    {
      swap(gainCurr, gainNext);
      gainCurr[N - 1] = gainCurr[N] = 0;
      int opt = prices[N - 1];
      for (int i = N - 2; i >= 0; --i)
      {
        gainCurr[i] = max2(gainCurr[i + 1], opt - prices[i]);
        opt = max2(opt, prices[i] + gainNext[i + 1]);
      }
    }
    return gainCurr[0];
  }

private:
  int numRise (vector<int> &prices)
  {
    int N = prices.size();
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
};
