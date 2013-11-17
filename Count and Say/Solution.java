public class Solution
{

  String getNext (String cur)
  {
    StringBuilder sb = new StringBuilder();
    int i = 0;
    while (i < cur.length())
    {
      if (i + 1 < cur.length() && cur.charAt(i) == '2' && cur.charAt(i + 1) == '1')
      {
        sb.append("1211");
        i += 2;
      }
      else if (i + 1 < cur.length() && cur.charAt(i) == '1' && cur.charAt(i + 1) == '1')
      {
        sb.append("21");
        i += 2;
      }
      else // if (cur.charAt(i) == '1')
      {
        sb.append("11");
        ++i;
      }
    }
    return sb.toString();
  }

  public String countAndSay (int n)
  {
    String cur = "1";
    int cn = 1;
    while (cn < n)
    {
      System.out.format("%d: %s\n", cn, cur);
      cur = getNext(cur);
      ++cn;
    }
    System.out.format("%d: %s\n", cn, cur);
    return cur;
  }

}
