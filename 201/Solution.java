public class Solution
{
  public int rangeBitwiseAnd (int m, int n)
  {
    int ret = 0;
    for (int i = 0; i < 31; ++i)
    {
    	int k = 1 << i;
    	if ((m & k) > 0 && m / k == n / k)
    		ret |= k;
    }
    return ret;
  }
}
