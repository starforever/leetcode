public class Solution
{
  public int[] plusOne (int[] digits)
  {
    if (digits == null)
      return null;
    int n = digits.length;
    if (n == 0)
      return digits;
    int i = n - 1;
    while (i >= 0 && digits[i] == 9)
      --i;
    if (i < 0)
    {
      int[] digits2 = new int[n + 1];
      digits2[0] = 1;
      return digits2;
    }
    ++digits[i];
    for (i = i + 1; i < n; ++i)
      digits[i] = 0;
    return digits;
  }
}
