public class Solution
{
  public String convert (String s, int nRows)
  {
    StringBuilder[] buffer = new StringBuilder[nRows];
    for (int i = 0; i < nRows; ++i)
      buffer[i] = new StringBuilder();
    int indexStr = 0;
    while (indexStr < s.length())
    {
      for (int i = 0; i < nRows && indexStr < s.length(); ++i)
        buffer[i].append(s.charAt(indexStr++));
      for (int i = nRows - 2; i >= 1 && indexStr < s.length(); --i)
        buffer[i].append(s.charAt(indexStr++));
    }
    StringBuilder concat = new StringBuilder();
    for (int i = 0; i < nRows; ++i)
      concat.append(buffer[i].toString());
    return concat.toString();
  }
}
