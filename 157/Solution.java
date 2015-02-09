public class Solution extends Reader4
{
  public int read (char[] buf, int n)
  {
    char[] word = new char[4];
    int cnt = 0;
    while (cnt < n)
    {
      int m = read4(word);
      if (m == 0)
        break;
      for (int i = 0; i < m && cnt < n; ++i)
        buf[cnt++] = word[i];
    }
    return cnt;
  }
}
