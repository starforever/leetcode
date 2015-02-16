public class Solution
{
  public int majorityElement (int[] num)
  {
    if (num == null || num.length == 0)
      throw new IllegalArgumentException();
    Arrays.sort(num);
    return num[num.length / 2];
  }
}
