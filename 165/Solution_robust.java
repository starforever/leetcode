public class Solution
{
  private int compareNumber (String num1, String num2)
  {
    int L = Math.max(num1.length(), num2.length());
    for (int i = L - 1; i >= 0; --i)
    {
      int idx1 = num1.length() - 1 - i;
      int idx2 = num2.length() - 1 - i;
      char c1 = idx1 >= 0 ? num1.charAt(idx1) : '0';
      char c2 = idx2 >= 0 ? num2.charAt(idx2) : '0';
      if (c1 != c2)
        return c1 < c2 ? -1 : 1;
    }
    return 0;
  }

  private boolean isAllZeroes (String num)
  {
    for (int i = 0; i < num.length(); ++i)
    {
      char c = num.charAt(i);
      if (c != '.' && c != '0')
        return false;
    }
    return true;
  }

  public int compareVersion (String version1, String version2)
  {
    if (version1 == null || version2 == null)
      throw new IllegalArgumentException();
    int i1 = 0, i2 = 0;
    int j1 = 0, j2 = 0;
    while (i1 < version1.length() && i2 < version2.length())
    {
      while (i1 < version1.length() && version1.charAt(i1) != '.')
        ++i1;
      while (i2 < version2.length() && version2.charAt(i2) != '.')
        ++i2;
      int c = compareNumber(version1.substring(j1, i1), version2.substring(j2, i2));
      if (c != 0)
        return c;
      j1 = ++i1;
      j2 = ++i2;
    }
    if (i1 < version1.length())
      return isAllZeroes(version1.substring(i1)) ? 0 : 1;
    else if (i2 < version2.length())
      return isAllZeroes(version2.substring(i2)) ? 0 : -1;
    else
      return 0;
  }
}
