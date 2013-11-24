public class Solution
{

  class Line
  {

    int x, y;

    int gcd (int x, int y)
    {
      if (x % y == 0)
        return y;
      else
        return gcd(y, x % y);
    }

    public Line (int x, int y)
    {
      if (x == 0)
        y = 1;
      else if (y == 0)
        x = 1;
      else
      {
        int g = gcd(Math.abs(x), Math.abs(y));
        x /= g;
        y /= g;
        if (x < 0 || x == 0 && y < 0)
        {
          x = -x;
          y = -y;
        }
      }
      this.x = x;
      this.y = y;
    }

    public boolean equals (Object obj)
    {
      if (!(obj instanceof Line))
        return false;
      Line o = (Line)obj;
      return x == o.x && y == o.y;
    }

    public int hashCode ()
    {
      return x * y;
    }

  }

  public int maxPoints (Point[] points)
  {
    if (points == null)
      return 0;
    int N = points.length;
    HashMap<Line, HashSet<Integer>> lineTable = new HashMap<Line, HashSet<Integer>>();
    int maxLinePoint = 0;
    for (int i = 0; i < N; ++i)
    {
      int numSamePoint = 1;
      for (int j = i + 1; j < N; ++j)
      {
        int dx = points[i].x - points[j].x, dy = points[i].y - points[j].y;
        if (dx == 0 && dy == 0)
          ++numSamePoint;
        else
        {
          Line line = new Line(dx, dy);
          if (!lineTable.containsKey(line))
            lineTable.put(line, new HashSet<Integer>());
          lineTable.get(line).add(i);
          lineTable.get(line).add(j);
        }
      }
      maxLinePoint = Math.max(maxLinePoint, numSamePoint);
    }
    for (HashSet<Integer> lineSet : lineTable.values())
      maxLinePoint = Math.max(maxLinePoint, lineSet.size());
    return maxLinePoint;
  }

}
