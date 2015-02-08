public class Solution
{
  public int numDistinct (String S, String T)
  {
    int N = S.length(), M = T.length();
    int[][] numSeq = new int[N + 1][M + 1];
    numSeq[0][0] = 1;
    for (int i = 1; i <= N; ++i)
    {
      numSeq[i][0] = 1;
      for (int j = 1; j <= M; ++j)
      {
        numSeq[i][j] = numSeq[i - 1][j];
        if (S.charAt(i - 1) == T.charAt(j - 1))
          numSeq[i][j] += numSeq[i - 1][j - 1];
      }
    }
    return numSeq[N][M];
  }
}
