public class Solution
{
  public ArrayList<String> fullJustify (String[] words, int L)
  {
    ArrayList<String> ret = new ArrayList<String>();
    if (words == null || words.length == 0)
      return ret;
    int N = words.length;
    int i = 0;
    while (i < N)
    {
      int j = i;
      int len = words[i++].length();
      while (i < N && len + 1 + words[i].length() <= L)
        len += 1 + words[i++].length();
      StringBuilder sb = new StringBuilder();
      if (i == N || i - j == 1)
      {
        sb.append(words[j]);
        for (int k = j + 1; k < i; ++k)
        {
          sb.append(' ');
          sb.append(words[k]);
        }
        while (sb.length() < L)
          sb.append(' ');
      }
      else
      {
        int rem = L - len;
        int gap = i - j - 1;
        int n = rem / gap;
        int r = rem % gap;
        sb.append(words[j]);
        for (int k = j + 1; k < i; ++k)
        {
          sb.append(' ');
          for (int u = 0; u < n; ++u)
            sb.append(' ');
          if (k - j <= r)
            sb.append(' ');
          sb.append(words[k]);
        }
      }
      ret.add(sb.toString());
    }
    return ret;
  }
}
