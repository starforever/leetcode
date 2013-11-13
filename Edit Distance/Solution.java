public class Solution
{
  public int minDistance (String word1, String word2)
  {
    int N1 = word1.length(), N2 = word2.length();
    int[][] numEdit = new int[N1 + 1][N2 + 1];
    numEdit[0][0] = 0;
    for (int i = 1; i <= N1; ++i)
      numEdit[i][0] = i;
    for (int i = 1; i <= N2; ++i)
      numEdit[0][i] = i;
    for (int i = 1; i <= N1; ++i)
      for (int j = 1; j <= N2; ++j)
      {
        numEdit[i][j] = numEdit[i - 1][j - 1] + (word1.charAt(i - 1) != word2.charAt(j - 1) ? 1 : 0);
        numEdit[i][j] = Math.min(numEdit[i][j], numEdit[i - 1][j] + 1);
        numEdit[i][j] = Math.min(numEdit[i][j], numEdit[i][j - 1] + 1);
      }
    return numEdit[N1][N2];
  }
}
