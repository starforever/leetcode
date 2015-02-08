public class Solution
{
  public int ladderLength (String start, String end, HashSet<String> dict)
  {
    if (start == null || end == null || dict == null)
      return 0;
    if (!dict.contains(start))
      return 0;
    if (start.equals(end))
      return 1;
    LinkedList<String> queue = new LinkedList<String>();
    HashMap<String, Integer> vis = new HashMap<String, Integer>();
    queue.add(start);
    vis.put(start, 1);
    while (!queue.isEmpty())
    {
      String cur = queue.remove();
      int step = vis.get(cur);
      char[] buffer = cur.toCharArray();
      for (int i = 0; i < cur.length(); ++i)
      {
        for (char c = 'a'; c <= 'z'; ++c)
        {
          if (c == cur.charAt(i))
            continue;
          buffer[i] = c;
          String next = new String(buffer);
          if (dict.contains(next) && !vis.containsKey(next))
          {
            if (next.equals(end))
              return step + 1;
            vis.put(next, step + 1);
            queue.add(next);
          }
        }
        buffer[i] = cur.charAt(i);
      }
    }
    return 0;
  }
}
