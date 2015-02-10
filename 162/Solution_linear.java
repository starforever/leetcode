public class Solution
{
  public int findPeakElement (int[] num)
  {
    if (num == null || num.length == 0)
      throw new IllegalArgumentException();
    int i = 0;
    while (i + 1 < num.length && num[i + 1] > num[i])
      ++i;
    return i;
  }
}
