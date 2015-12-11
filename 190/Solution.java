public class Solution
{
  public int reverseBits (int n)
  {
    int m = 0;
    for (int i = 0; i < 32; ++i)
    {
      m <<= 1;
      m |= n & 1;
      n >>= 1;
    }
    return m;
  }
}
