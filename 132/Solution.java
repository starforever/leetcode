public class Solution
{

  boolean[][] calcIsPalindrome (String s)
  {
    int N = s.length();
    boolean[][] ret = new boolean[N][N + 1];
    for (int i = 0; i < N; ++i)
      ret[i][i] = ret[i][i + 1] = true;
    for (int l = 2; l <= N; ++l)
      for (int i = 0; i + l <= N; ++i)
        ret[i][i + l] = s.charAt(i) == s.charAt(i + l - 1) && ret[i + 1][i + l - 1];
    return ret;
  }

  public int minCut (String s)
  {
    int N = s.length();
    boolean[][] isPalindrome = calcIsPalindrome(s);
    int[] numPart = new int[N + 1];
    numPart[0] = 0;
    for (int i = 1; i <= N; ++i)
    {
      numPart[i] = Integer.MAX_VALUE;
      for (int j = 0; j < i; ++j)
        if (isPalindrome[j][i])
          numPart[i] = Math.min(numPart[i], numPart[j] + 1);
    }
    return numPart[N] - 1;
  }
}
