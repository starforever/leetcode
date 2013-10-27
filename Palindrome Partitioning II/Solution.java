public class Solution
{

  boolean isPalindrome (String s)
  {
    int n = s.length();
    for (int i = 0; i < n / 2; ++i)
      if (s.charAt(i) != s.charAt(n - 1 - i))
        return false;
    return true;
  }

  public int minCut (String s)
  {
    int N = s.length();
    int[] numCut = new int[N + 1];
    numCut[0] = 0;
    for (int i = 1; i <= N; ++i)
    {
      numCut[i] = Integer.MAX_VALUE;
      for (int j = 0; j < i; ++j)
        if (isPalindrome(s.substring(j, i)))
          numCut[i] = Math.min(numCut[i], numCut[j] + 1);
    }
    return numCut[N];
  }
}
