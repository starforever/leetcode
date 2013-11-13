public class Solution
{
  public ArrayList<Interval> insert (ArrayList<Interval> intervals, Interval newInterval)
  {
    ArrayList<Interval> ret = new ArrayList<Interval>();
    int n = intervals.size();
    int i = 0;
    while (i < n && intervals.get(i).end < newInterval.start)
      ret.add(intervals.get(i++));
    int start = newInterval.start;
    if (i < n && intervals.get(i).start < start)
      start = intervals.get(i).start;
    while (i < n && intervals.get(i).start <= newInterval.end)
      ++i;
    int end = newInterval.end;
    if (i - 1 >= 0 && intervals.get(i - 1).end > end)
      end = intervals.get(i - 1).end;
    ret.add(new Interval(start, end));
    while (i < n)
      ret.add(intervals.get(i++));
    return ret;
  }
}
