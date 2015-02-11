public class Solution
{
  private int ceilDiv (int a, int b)
  {
    int r = a / b;
    if (a % b > 0)
      ++r;
    return r;
  }

  public int maximumGap (int[] num)
  {
    if (num == null)
      throw new IllegalArgumentException();
    if (num.length < 2)
      return 0;
    int N = num.length;
    int A = Integer.MAX_VALUE, B = Integer.MIN_VALUE;
    for (int i = 0; i < N; ++i)
    {
      if (num[i] < A)
        A = num[i];
      if (num[i] > B)
        B = num[i];
    }
    int bucketSize = ceilDiv(B - A, N - 1);
    int bucketNum = ceilDiv(B - A + 1, bucketSize);
    int[] bucketMin = new int[bucketNum];
    int[] bucketMax = new int[bucketNum];
    for (int i = 0; i < bucketNum; ++i)
    {
      bucketMin[i] = Integer.MAX_VALUE;
      bucketMax[i] = Integer.MIN_VALUE;
    }
    for (int i = 0; i < N; ++i)
    {
      int idx = (num[i] - A) / bucketSize;
      if (num[i] < bucketMin[idx])
        bucketMin[idx] = num[i];
      if (num[i] > bucketMax[idx])
        bucketMax[idx] = num[i];
    }
    int maxGap = 0;
    int lastMax = -1;
    for (int i = 0; i < bucketNum; ++i)
    {
      if (bucketMax[i] != Integer.MIN_VALUE)
      {
        if (lastMax != -1 && bucketMin[i] - lastMax > maxGap)
          maxGap = bucketMin[i] - lastMax;
        lastMax = bucketMax[i];
      }
    }
    return maxGap;
  }
}
