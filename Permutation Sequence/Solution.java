public class Solution
{
  public String getPermutation (int n, int k)
  {
    --k;
    int fact = 1;
    for (int i = 2; i <= n; ++i)
      fact *= i;
    if (k >= fact)
      return null;
    boolean[] used = new boolean[n];
    StringBuilder sb = new StringBuilder();
    for (int i = n; i >= 1; --i)
    {
      fact /= i;
      int m = k / fact;
      k %= fact;
      for (int j = 0; j < n; ++j)
      {
        if (used[j])
          continue;
        if (m == 0)
        {
          used[j] = true;
          sb.append(j + 1);
          break;
        }
        --m;
      }
    }
    return sb.toString();
  }
}
