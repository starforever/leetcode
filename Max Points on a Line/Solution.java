import java.util.*;

public class Solution
{

  class Line
  {

    Point start, diff;

    public Line (Point p1, Point p2)
    {
      start = new Point(p1.x , p1.y);
      diff = new Point(p2.x - p1.x, p2.y - p1.y);
      normDiff(diff);
      normStart(start, diff);
    }

    void normDiff (Point pd)
    {
      if (pd.x != 0 && pd.y != 0)
      {
        int g = gcd(Math.abs(pd.x), Math.abs(pd.y));
        pd.x /= g;
        pd.y /= g;
      }
      else if (pd.x != 0)
        pd.x = 1;
      else if (pd.y != 0)
        pd.y = 1;
      if (Math.abs(pd.x) >= Math.abs(pd.y) && pd.x < 0 || Math.abs(pd.x) < Math.abs(pd.y) && pd.y < 0)
      {
        pd.x = -pd.x;
        pd.y = -pd.y;
      }
    }

    void normStart (Point ps, Point pd)
    {
      if (pd.x == 0 && pd.y == 0)
        return;
      int k;
      if (Math.abs(pd.x) >= Math.abs(pd.y))
      {
        int sx = ps.x % pd.x;
        if (sx < 0)
          sx += pd.x;
        k = (sx - ps.x) / pd.x;
      }
      else
      {
        int sy = ps.y % pd.y;
        if (sy < 0)
          sy += pd.y;
        k = (sy - ps.y) / pd.y;
      }
      ps.x += k * pd.x;
      ps.y += k * pd.y;
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
      return equals(start, o.start) && equals(diff, o.diff);
    }

    boolean equals (Point p1, Point p2)
    {
      return p1.x == p2.x && p1.y == p2.y;
    }

    public int hashCode ()
    {
      return hashCode(start) * hashCode(diff);
    }

    int hashCode (Point p)
    {
      return p.x * p.y;
    }

  }

  public int maxPoints (Point[] points)
  {
    if (points == null)
      return 0;
    int N = points.length;
    HashMap<Line, HashSet<Integer>> lineTable = new HashMap<Line, HashSet<Integer>>();
    for (int i = 0; i < N; ++i)
    {
      for (int j = i; j < N; ++j)
      {
        Line line = new Line(points[i], points[j]);
        if (!lineTable.containsKey(line))
          lineTable.put(line, new HashSet<Integer>());
        lineTable.get(line).add(i);
        lineTable.get(line).add(j);
      }
    }
    int maxLinePoint = 0;
    for (HashSet<Integer> lineSet : lineTable.values())
      maxLinePoint = Math.max(maxLinePoint, lineSet.size());
    return maxLinePoint;
  }

  public static void main (String[] args)
  {
    Scanner sc = new Scanner(System.in);
    ArrayList<Point> pointList = new ArrayList<Point>();
    while (sc.hasNextInt())
    {
      int x = sc.nextInt(), y = sc.nextInt();
      pointList.add(new Point(x, y));
    }
    Point[] points = new Point[pointList.size()];
    pointList.toArray(points);
    Solution sol = new Solution();
    System.out.println(sol.maxPoints(points));
  }

}
