public class Solution
{

  String getNext (String cur)
  {
    StringBuilder sb = new StringBuilder();
    int i = 0;
    while (i < cur.length())
    {
      int j = i + 1;
      while (j < cur.length() && cur.charAt(j) == cur.charAt(i))
        ++j;
      sb.append(j - i);
      sb.append(cur.charAt(i));
      i = j;
    }
    return sb.toString();
  }

  public String countAndSay (int n)
  {
    String seq = "1";
    while (n > 1)
    {
      seq = getNext(seq);
      --n;
    }
    return seq;
  }

}
