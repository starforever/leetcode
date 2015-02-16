public class Solution
{
  private static final int NUM_ALPHABET = 26;

  public String convertToTitle (int n)
  {
    int L = 1;
    long num = NUM_ALPHABET;
    --n;
    while (n >= num)
    {
      n -= num;
      ++L;
      num *= NUM_ALPHABET;
    }
    char[] title = new char[L];
    for (int i = L - 1; i >= 0; --i)
    {
      title[i] = (char)(n % NUM_ALPHABET + 'A');
      n /= NUM_ALPHABET;
    }
    return new String(title);
  }
}
