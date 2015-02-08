public class Solution
{
  public String addBinary (String a, String b)
  {
    if (a == null || b == null)
      return null;
    if (a.length() < b.length())
    {
      String t = a;
      a = b;
      b = t;
    }
    if (b.isEmpty())
      return a;
    char[] cr = new char[a.length() + 1];
    int i = a.length() - 1, j = b.length() - 1, k = 0;
    int x = 0;
    while (j >= 0)
    {
      x += (a.charAt(i--) - '0') + (b.charAt(j--) - '0');
      cr[k++] = (x & 1) > 0 ? '1' : '0';
      x >>= 1;
    }
    while (i >= 0)
    {
      x += a.charAt(i--) - '0';
      cr[k++] = (x & 1) > 0 ? '1' : '0';
      x >>= 1;
    }
    if (x > 0)
      cr[k++] = '1';
    StringBuilder sb = new StringBuilder();
    for (k = k - 1; k >= 0; --k)
      sb.append(cr[k]);
    return sb.toString();
  }
}
