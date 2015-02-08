public class Solution
{

  HashMap<Integer, Boolean> label;

  int findSeq (int x)
  {
    label.put(x, true);
    int cnt = 1;
    int y = x + 1;
    while (label.containsKey(y))
    {
      label.put(y, true);
      ++cnt;
      ++y;
    }
    y = x - 1;
    while (label.containsKey(y))
    {
      label.put(y, true);
      ++cnt;
      --y;
    }
    return cnt;
  }

  public int longestConsecutive (int[] num)
  {
    if (num == null || num.length == 0)
      return 0;
    int N = num.length;
    label = new HashMap<Integer, Boolean>();
    for (int i = 0; i < N; ++i)
      label.put(num[i], false);
    int maxSeq = 0;
    for (int i = 0; i < N; ++i)
      if (!label.get(num[i]))
        maxSeq = Math.max(maxSeq, findSeq(num[i]));
    return maxSeq;
  }

}
