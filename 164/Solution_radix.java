public class Solution
{
  private int[] bk0;
  private int[] bk1;

  private void radixSort (int[] num, int r)
  {
    int n0 = 0, n1 = 0;
    for (int i = 0; i < num.length; ++i)
    {
      if ((num[i] & 1 << r) == 0)
        bk0[n0++] = num[i];
      else
        bk1[n1++] = num[i];
    }
    int n = 0;
    for (int i = 0; i < n0; ++i)
      num[n++] = bk0[i];
    for (int i = 0; i < n1; ++i)
      num[n++] = bk1[i];
  }

  public int maximumGap (int[] num)
  {
    if (num == null)
      throw new IllegalArgumentException();
    if (num.length < 2)
      return 0;
    bk0 = new int[num.length];
    bk1 = new int[num.length];
    for (int i = 0; i < 31; ++i)
      radixSort(num, i);
    int maxGap = 0;
    for (int i = 0; i + 1 < num.length; ++i)
    {
      if (num[i + 1] - num[i] > maxGap)
        maxGap = num[i + 1] - num[i];
    }
    return maxGap;
  }
}
