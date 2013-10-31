public class Solution
{
  public boolean isInterleave (String s1, String s2, String s3)
  {
    if (s1 == null || s2 == null || s3 == null)
      return false;
    int n1 = s1.length(), n2 = s2.length(), n3 = s3.length();
    if (n1 + n2 != n3)
      return false;
    boolean[][] flag = new boolean[n1 + 1][n2 + 1];
    flag[0][0] = true;
    for (int i1 = 0; i1 <= n1; ++i1)
      for (int i2 = 0; i2 <= n2; ++i2)
      {
        flag[i1][i2] |= i1 > 0 && s3.charAt(i1 + i2 - 1) == s1.charAt(i1 - 1) && flag[i1 - 1][i2];
        flag[i1][i2] |= i2 > 0 && s3.charAt(i1 + i2 - 1) == s2.charAt(i2 - 1) && flag[i1][i2 - 1];
      }
    return flag[n1][n2];
  }
}
