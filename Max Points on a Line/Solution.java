public class Solution
{

  class Line
  {

    int dx, dy;

    public Line (int dx, int dy)
    {
      if (dy != 0)
      {
        int g = gcd(Math.abs(dx), Math.abs(dy));
        dx /= g;
        dy /= g;
      }
      else
        dx = 1;
      if (dy < 0)
      {
        dx = -dx;
        dy = -dy;
      }
      this.dx = dx;
      this.dy = dy;
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
    HashMap<Line, Integer> lineTable = new HashMap<Line, Integer>();
    int maxLinePoint = 0;
    for (int i = 0; i < N; ++i)
    {
      lineTable.clear();
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
