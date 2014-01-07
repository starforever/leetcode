public class Solution
{

  static class Segment
  {
    int level;
    int length;

    public Segment (int level, int length)
    {
      this.level = level;
      this.length = length;
    }
  }

  public int trap (int[] A)
  {
    Stack<Segment> stack = new Stack<Segment>();
    int highest = 0;
    int total = 0;
    for (int i = 0; i < A.length; ++i)
    {
      int newLevel = Math.min(A[i], highest);
      highest = Math.max(highest, A[i]);
      int sumLength = 0;
      while (!stack.empty() && stack.peek().level <= A[i])
      {
        total += stack.peek().length * (newLevel - stack.peek().level);
        sumLength += stack.peek().length;
        stack.pop();
      }
      stack.push(new Segment(A[i], sumLength + 1));
    }
    return total;
  }

}
