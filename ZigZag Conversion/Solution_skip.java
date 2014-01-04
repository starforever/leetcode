public class Solution
{
  public String convert (String s, int nRows)
  {
    if (nRows == 0)
      return "";
    if (nRows == 1)
      return s;
    StringBuilder sb = new StringBuilder();
    for (int row = 0; row < nRows; ++row)
    {
      int i = row;
      boolean atMid = false;
      while (i < s.length())
      {
        sb.append(s.charAt(i));
        if (row == 0 || row == nRows - 1)
          i += (nRows - 1) * 2;
        else
        {
          if (atMid)
            i += row * 2;
          else
            i += (nRows - row - 1) * 2;
          atMid = !atMid;
        }
      }
    }
    return sb.toString();
  }
}
