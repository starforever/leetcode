public class Solution
{

  int N, M;

  HashMap<String, Integer> wordCount;

  boolean isConcatenation (String S)
  {
    HashMap<String, Integer> wordCount2 = new HashMap<String, Integer>();
    for (int i = 0; i < N; ++i)
    {
      String word = S.substring(i * M, (i + 1) * M);
      if (!wordCount.containsKey(word))
        return false;
      if (!wordCount2.containsKey(word))
        wordCount2.put(word, 1);
      else
        wordCount2.put(word, wordCount2.get(word) + 1);
      if (wordCount2.get(word) > wordCount.get(word))
        return false;
    }
    return true;
  }

  public ArrayList<Integer> findSubstring (String S, String[] L)
  {
    ArrayList<Integer> posList = new ArrayList<Integer>();
    if (S == null || S.isEmpty() || L == null || L.length == 0 || L[0].isEmpty())
      return posList;
    N = L.length;
    M = L[0].length();
    wordCount = new HashMap<String, Integer>();
    for (int i = 0; i < N; ++i)
    {
      if (!wordCount.containsKey(L[i]))
        wordCount.put(L[i], 1);
      else
        wordCount.put(L[i], wordCount.get(L[i]) + 1);
    }
    for (int i = 0; i + N * M <= S.length(); ++i)
      if (isConcatenation(S.substring(i, i + N * M)))
        posList.add(i);
    return posList;
  }

}
