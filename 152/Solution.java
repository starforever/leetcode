public class Solution
{
  private int maxProduct (int[] A, int start, int end)
  {
    int prod = 1;
    for (int i = start; i < end; ++i)
      prod *= A[i];
    if (prod > 0)
      return prod;
    int ans = prod;
    int part = 1;
    int i = start;
    while (A[i] > 0)
      part *= A[i++];
    part *= A[i++];
    if (i < end && prod / part > ans)
      ans = prod / part;
    part = 1;
    i = end - 1;
    while (A[i] > 0)
      part *= A[i--];
    part *= A[i--];
    if (i >= start && prod / part > ans)
      ans = prod / part;
    return ans;
  }

  public int maxProduct (int[] A)
  {
    if (A == null || A.length == 0)
      throw new IllegalArgumentException();
    int i = 0, j;
    int maxP = Integer.MIN_VALUE;
    boolean hasZero = false;
    while (true)
    {
      while (i < A.length && A[i] == 0)
      {
        hasZero = true;
        ++i;
      }
      if (i >= A.length)
        break;
      j = i;
      while (i < A.length && A[i] != 0)
        ++i;
      int p = maxProduct(A, j, i);
      if (p > maxP)
        maxP = p;
    }
    if (hasZero && maxP < 0)
      maxP = 0;
    return maxP;
  }
}
