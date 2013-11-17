public class Solution
{

  int N, M;

  HashMap<String, Integer> wordIndex;
  int[] wordCount;

  boolean isConcatenation (String S)
  {
    int[] wordCount2 = new int[wordIndex.size()];
    for (int i = 0; i < N; ++i)
    {
      String word = S.substring(i * M, (i + 1) * M);
      if (!wordIndex.containsKey(word))
        return false;
      int idx = wordIndex.get(word);
      ++wordCount2[idx];
      if (wordCount2[idx] > wordCount[idx])
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
    wordIndex = new HashMap<String, Integer>();
    for (int i = 0; i < N; ++i)
    {
      if (!wordIndex.containsKey(L[i]))
        wordIndex.put(L[i], wordIndex.size());
    }
    wordCount = new int[wordIndex.size()];
    for (int i = 0; i < N; ++i)
      ++wordCount[wordIndex.get(L[i])];
    for (int i = 0; i + N * M <= S.length(); ++i)
      if (isConcatenation(S.substring(i, i + N * M)))
        posList.add(i);
    return posList;
  }

}
