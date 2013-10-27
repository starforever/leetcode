public class Solution
{

  static class State
  {
    int step;
    LinkedList<String> prev = new LinkedList<String>();

    public State (int step)
    {
      this.step = step;
    }
  }

  HashMap<String, State> vis;

  ArrayList<ArrayList<String>> findSeqList (String cur)
  {
    ArrayList<ArrayList<String>> ret = new ArrayList<ArrayList<String>>();
    for (String next : vis.get(cur).prev)
    {
      for (ArrayList<String> nextSeq : findSeqList(next))
      {
        nextSeq.add(cur);
        ret.add(nextSeq);
      }
    }
    if (ret.isEmpty())
    {
      ret.add(new ArrayList<String>(Arrays.asList(cur)));
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
            nextState.prev.add(cur);
          }
        }
    }
    return new ArrayList<ArrayList<String>>();
  }
}
