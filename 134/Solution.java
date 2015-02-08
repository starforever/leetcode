public class Solution
{
  public int canCompleteCircuit (int[] gas, int[] cost)
  {
    int N = gas.length;
    int[] diff = new int[N];
    for (int i = 0; i < N; ++i)
      diff[i] = gas[i] - cost[i];
    int sum = 0;
    int lowest = 0;
    int lowestIdx = 0;
    for (int i = 0; i < N; ++i)
    {
      sum += diff[i];
      if (sum < lowest)
      {
        lowest = sum;
        lowestIdx = i + 1;
      }
    }
    if (sum < 0)
      return -1;
    return lowestIdx;
  }
}