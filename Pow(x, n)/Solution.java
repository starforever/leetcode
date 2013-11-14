public class Solution
{
  public double pow (double x, int n)
  {
    if (n < 0)
    {
      if (n > Integer.MIN_VALUE)
        return 1.0 / pow(x, -n);
      else
        return 1.0 / (pow(x, -(n + 1)) * x);
    }
    double res = 1.0;
    for (int i = 30; i >= 0; --i)
    {
      res *= res;
      if ((n & 1 << i) > 0)
        res *= x;
    }
    return res;
  }
}
