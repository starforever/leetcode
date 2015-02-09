public class Solution extends Reader4
{
  private char[] word = new char[4];
  private int cur = 0, len = read4(word);

  public int read (char[] buf, int n)
  {
    int cnt = 0;
    while (cnt < n)
    {
      if (cur == len)
      {
        len = read4(word);
        cur = 0;
        if (len == 0)
          break;
      }
      buf[cnt++] = word[cur++];
    }
    return cnt;
  }
}
