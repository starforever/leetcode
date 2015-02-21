public class Solution
{
  private int N;
  private String[] numStr;

  private int[] cnt;
  private int[] pos;
  private String[] buffer;

  public String largestNumber (int[] num)
  {
    N = num.length;
    numStr = new String[N];
    for (int i = 0; i < N; ++i)
      numStr[i] = Integer.toString(num[i]);
    cnt = new int[10];
    pos = new int[10];
    buffer = new String[N];
    for (int r = 9; r >= 0; --r)
      radixSort(r);
    StringBuilder sb = new StringBuilder();
    for (int i = N - 1; i >= 0; --i)
      sb.append(numStr[i]);
    int i = 0;
    while (i + 1 < sb.length() && sb.charAt(i) == '0')
      ++i;
    return sb.substring(i);
  }

  private void radixSort (int r)
  {
    for (int i = 0; i < 10; ++i)
      cnt[i] = 0;
    for (int i = 0; i < N; ++i)
    {
      int d = getNumDigit(numStr[i], r);
      ++cnt[d];
    }
    pos[0] = 0;
    for (int i = 1; i < 10; ++i)
      pos[i] = pos[i - 1] + cnt[i - 1];
    for (int i = 0; i < N; ++i)
    {
      int d = getNumDigit(numStr[i], r);
      buffer[pos[d]++] = numStr[i];
    }
    for (int i = 0; i < N; ++i)
      numStr[i] = buffer[i];
  }

  private int getNumDigit (String num, int r)
  {
    return num.charAt(r % num.length()) - '0';
  }
}
