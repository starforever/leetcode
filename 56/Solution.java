public class Solution
{

  static class IntervalAsc implements Comparator<Interval>
  {
    public int compare (Interval o1, Interval o2)
    {
      if (o1.start != o2.start)
        return o1.start < o2.start ? -1 : 1;
      else if (o1.end != o2.end)
        return o1.end < o2.end ? -1 : 1;
      else
        return 0;
    }
  }

  public ArrayList<Interval> merge (ArrayList<Interval> intervals)
  {
    Collections.sort(intervals, new IntervalAsc());
    ArrayList<Interval> ret = new ArrayList<Interval>();
    int n = intervals.size();
    int i = 0;
    while (i < n)
    {
      int start = intervals.get(i).start, end = intervals.get(i).end;
      int j = i + 1;
      while (j < n && intervals.get(j).start <= end)
        end = Math.max(end, intervals.get(j++).end);
      ret.add(new Interval(start, end));
      i = j;
    }
    return ret;
  }

}
