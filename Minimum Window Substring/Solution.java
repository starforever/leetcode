public class Solution
{

  static final int NUM_CHAR = 128;

  public String minWindow (String S, String T)
  {
    int[] numCT = new int[NUM_CHAR];
    for (int i = 0; i < T.length(); ++i)
      ++numCT[(int)T.charAt(i)];
    int[] numCS = new int[NUM_CHAR];
    int match = 0;
    for (int i = 0; i < NUM_CHAR; ++i)
      if (numCS[i] >= numCT[i])
        ++match;
    int f = 0, e = 0;
    while (e < S.length() && match < NUM_CHAR)
    {
      int idx = S.charAt(e);
      ++numCS[idx];
      if (numCS[idx] == numCT[idx])
        ++match;
      ++e;
    }
    if (match < NUM_CHAR)
      return "";
    int minL = e - f;
    String window = S.substring(f, e);
    while (e < S.length())
    {
      int idx = S.charAt(f);
      if (numCS[idx] == numCT[idx])
        --match;
      --numCS[idx];
      ++f;
      while (e < S.length() && match < NUM_CHAR)
      {
        idx = S.charAt(e);
        ++numCS[idx];
        if (numCS[idx] == numCT[idx])
          ++match;
        ++e;
      }
      if (match == NUM_CHAR && e - f < minL)
      {
        minL = e - f;
        window = S.substring(f, e);
      }
    }
    return window;
  }

}
