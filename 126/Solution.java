public class Solution
{

  static class State
  {
    int step;
    LinkedList<String> prevList = new LinkedList<String>();

    public State (int step)
    {
      this.step = step;
    }
  }

  HashMap<String, State> vis;

  ArrayList<ArrayList<String>> findSeqList (String cur)
  {
    State curState = vis.get(cur);
    if (curState.prevList.isEmpty())
      return new ArrayList<ArrayList<String>>(Arrays.asList(new ArrayList<String>(Arrays.asList(cur))));
    ArrayList<ArrayList<String>> ret = new ArrayList<ArrayList<String>>();
    for (String prev : curState.prevList)
    {
      for (ArrayList<String> seq : findSeqList(prev))
      {
        seq.add(cur);
        ret.add(seq);
      }
    }
    return ret;
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
    vis = new HashMap<String, State>();
    queue.add(start);
    vis.put(start, new State(1));
    while (!queue.isEmpty())
    {
      String cur = queue.remove();
      State curState = vis.get(cur);
      if (cur.equals(end))
        return findSeqList(cur);
      char[] buffer = cur.toCharArray();
      for (int i = 0; i < cur.length(); ++i)
      {
        for (char c = 'a'; c <= 'z'; ++c)
        {
          if (c == cur.charAt(i))
            continue;
          buffer[i] = c;
          String next = new String(buffer);
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
            nextState.prevList.add(cur);
          }
        }
        buffer[i] = cur.charAt(i);
      }
    }
    return new ArrayList<ArrayList<String>>();
  }
}
