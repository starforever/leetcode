public class Solution
{
  public int findMin (int[] num)
  {
    if (num == null || num.length == 0)
      throw new IllegalArgumentException();
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < num.length; ++i)
      if (num[i] < min)
        min = num[i];
    return min;
  }
}
