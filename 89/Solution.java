public class Solution
{
  public ArrayList<Integer> grayCode (int n)
  {
    ArrayList<Integer> ret = new ArrayList<Integer>();
    ret.add(0);
    if (n == 0)
      return ret;
    ret.add(1);
    int high = 1;
    for (int i = 2; i <= n; ++i)
    {
      high <<= 1;
      for (int j = ret.size() - 1; j >= 0; --j)
        ret.add(ret.get(j) | high);
    }
    return ret;
  }
}
