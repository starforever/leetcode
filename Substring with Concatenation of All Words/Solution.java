public class Solution
{

  int N, M;

  HashMap<String, Integer> wordIndex;

  boolean[] present;

  boolean isConcatenation (String S)
  {
    Arrays.fill(present, false);
    for (int i = 0; i < N; ++i)
    {
      String word = S.substring(i * M, (i + 1) * M);
      if (!wordIndex.containsKey(word))
        return false;
      int idx = wordIndex.get(word);
      if (present[idx])
        return false;
      present[idx] = true;
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
      wordIndex.put(L[i], i);
    present = new boolean[N];
    for (int i = 0; i + N * M <= S.length(); ++i)
      if (isConcatenation(S.substring(i, i + N * M)))
        posList.add(i);
    return posList;
  }

}
