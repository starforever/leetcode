public class Solution
{
  private static final int NUM_ALPHABET = 26;

  public int titleToNumber (String s)
  {
    int L = 1;
    int num = NUM_ALPHABET;
    int cnt = 0;
    while (L < s.length())
    {
      cnt += num;
      ++L;
      num *= NUM_ALPHABET;
    }
    num = 1;
    for (int i = L - 1; i >= 0; --i)
    {
      cnt += (s.charAt(i) - 'A') * num;
      num *= NUM_ALPHABET;
    }
    ++cnt;
    return cnt;
  }
}
