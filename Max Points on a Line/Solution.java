public class Solution
{

  static class Line
  {

    int dx, dy;

    public Line (int dx, int dy)
    {
      if (dy < 0)
      {
        dx = -dx;
        dy = -dy;
      }
      int g;
      if (dx == 0 || dy == 0)
        g = dx + dy;
      else
        g = gcd(Math.abs(dx), Math.abs(dy));
      this.dx = dx / g;
      this.dy = dy / g;
    }

    int gcd (int x, int y)
    {
      if (x % y == 0)
        return y;
      else
        return gcd(y, x % y);
    }

    public boolean equals (Object obj)
    {
      if (!(obj instanceof Line))
        return false;
      Line o = (Line)obj;
      return dx == o.dx && dy == o.dy;
    }

    public int hashCode ()
    {
      return dx * dy;
    }

  }

  public int maxPoints (Point[] points)
  {
    if (points == null)
      return 0;
    int N = points.length;
    int maxLinePoint = 0;
    for (int i = 0; i < N; ++i)
    {
      HashMap<Line, Integer> lineTable = new HashMap<Line, Integer>();
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
            lineTable.put(line, 1);
          else
            lineTable.put(line, lineTable.get(line) + 1);
        }
      }
      int numLinePoint = 0;
      for (Integer num : lineTable.values())
        numLinePoint = Math.max(numLinePoint, num);
      maxLinePoint = Math.max(maxLinePoint, numLinePoint + numSamePoint);
    }
    return maxLinePoint;
  }

}
