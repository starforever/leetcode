public class Solution
{
  public int singleNumber (int[] A)
  {
    int ans = 0;
    for (int i = 0; i < 32; ++i)
    {
      int cnt = 0;
      for (int j = 0; j < A.length; ++j)
      {
        if ((A[j] & 1 << i) != 0)
          ++cnt;
      }
      if (cnt % 3 != 0)
        ans |= 1 << i;
    }
    return ans;
  }
}
