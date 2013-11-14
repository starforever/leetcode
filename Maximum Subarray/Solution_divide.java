public class Solution
{

  int N;
  int[] A;

  int maxSubArray (int start, int end)
  {
    if (end - start == 1)
      return A[start];
    int mid = (start + end) / 2;
    int ret = Math.max(maxSubArray(start, mid), maxSubArray(mid, end));
    int sum = 0, maxSumLeft = Integer.MIN_VALUE, maxSumRight = Integer.MIN_VALUE;
    for (int i = mid - 1; i >= start; --i)
    {
      sum += A[i];
      maxSumLeft = Math.max(maxSumLeft, sum);
    }
    sum = 0;
    for (int i = mid; i < end; ++i)
    {
      sum += A[i];
      maxSumRight = Math.max(maxSumRight, sum);
    }
    ret = Math.max(ret, maxSumLeft + maxSumRight);
    return ret;
  }

  public int maxSubArray (int[] A)
  {
    if (A == null || A.length == 0)
      return 0;
    this.A = A;
    N = A.length;
    return maxSubArray(0, N);
  }

}
