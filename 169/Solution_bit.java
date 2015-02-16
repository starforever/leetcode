public class Solution
{
  public int majorityElement (int[] num)
  {
    if (num == null || num.length == 0)
      throw new IllegalArgumentException();
    int ret = 0;
    for (int b = 0; b < 32; ++b)
    {
      int cnt = 0;
      for (int i = 0; i < num.length; ++i)
      {
        if ((num[i] & 1 << b) != 0)
          ++cnt;
      }
      if (cnt > num.length / 2)
        ret |= 1 << b;
    }
    return ret;
  }
}
