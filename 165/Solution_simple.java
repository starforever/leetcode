public class Solution
{
  public int compareVersion (String version1, String version2)
  {
    if (version1 == null || version2 == null)
      throw new IllegalArgumentException();
    String[] ver1 = version1.split("\\.");
    String[] ver2 = version2.split("\\.");
    for (int i = 0; i < ver1.length || i < ver2.length; ++i)
    {
      int v1 = i < ver1.length ? Integer.parseInt(ver1[i]) : 0;
      int v2 = i < ver2.length ? Integer.parseInt(ver2[i]) : 0;
      if (v1 != v2)
        return v1 < v2 ? -1 : 1;
    }
    return 0;
  }
}
