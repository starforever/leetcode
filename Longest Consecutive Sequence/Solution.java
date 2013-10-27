public class Solution
{

  static class State
  {
    int numLeft = 0, numRight = 0;
  }

  public int longestConsecutive (int[] num)
  {
    if (num == null)
      return 0;
    HashMap<Integer, State> stateTable = new HashMap<Integer, State>();
    int maxSeq = 0;
    for (int i = 0; i < num.length; ++i)
    {
      State sL = null, sR = null, s = new State();
      if (stateTable.containsKey(num[i] - 1))
      {
        sL = stateTable.get(num[i] - 1);
        s.numLeft = sL.numLeft + 1;
      }
      if (stateTable.containsKey(num[i] + 1))
      {
        sR = stateTable.get(num[i] + 1);
        s.numRight = sR.numRight + 1;
      }
      stateTable.put(num[i], s);
      if (sL != null)
        sL.numRight = s.numRight + 1;
      if (sR != null)
        sR.numLeft = s.numLeft + 1;
      maxSeq = Math.max(maxSeq, s.numLeft + s.numRight + 1);
    }
    return maxSeq;
  }

}
