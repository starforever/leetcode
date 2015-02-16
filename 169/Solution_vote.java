public class Solution
{
  public int majorityElement (int[] num)
  {
    if (num == null || num.length == 0)
      throw new IllegalArgumentException();
    int cur = num[0];
    int cnt = 1;
    for (int i = 1; i < num.length; ++i)
    {
      if (num[i] == cur)
        ++cnt;
      else if (cnt > 0)
        --cnt;
      else
      {
        cur = num[i];
        cnt = 1;
      }
    }
    return cur;
  }
}
