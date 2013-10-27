public class Solution
{

  static class State
  {
    int step;
    ArrayList<ArrayList<String>> seqList = new ArrayList<ArrayList<String>>();

    public State (int step)
    {
      this.step = step;
    }
  }

  public ArrayList<ArrayList<String>> findLadders (String start, String end, HashSet<String> dict)
  {
    if (start == null || end == null || dict == null)
      return null;
    if (!dict.contains(start))
      return new ArrayList<ArrayList<String>>();
    if (start.equals(end))
      return new ArrayList<ArrayList<String>>(Arrays.asList(new ArrayList<String>(Arrays.asList(start))));
    LinkedList<String> queue = new LinkedList<String>();
    HashMap<String, State> vis = new HashMap<String, State>();
    State startState = new State(1);
    startState.seqList.add(new ArrayList<String>(Arrays.asList(start)));
    queue.add(start);
    vis.put(start, startState);
    while (!queue.isEmpty())
    {
      String cur = queue.remove();
      State curState = vis.get(cur);
      if (cur.equals(end))
        return curState.seqList;
      for (int i = 0; i < cur.length(); ++i)
        for (char c = 'a'; c <= 'z'; ++c)
        {
          if (c == cur.charAt(i))
            continue;
          String next = cur.substring(0, i) + c + cur.substring(i + 1);
          if (!dict.contains(next))
            continue;
          if (!vis.containsKey(next))
          {
            vis.put(next, new State(curState.step + 1));
            queue.add(next);
          }
          State nextState = vis.get(next);
          if (curState.step + 1 == nextState.step)
          {
            for (ArrayList<String> curSeq : curState.seqList)
            {
              ArrayList<String> nextSeq = new ArrayList<String>(curSeq);
              nextSeq.add(next);
              nextState.seqList.add(nextSeq);
            }
          }
        }
    }
    return new ArrayList<ArrayList<String>>();
  }
}
