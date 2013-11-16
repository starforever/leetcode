public class Solution
{

  static class Column
  {
    int idx;
    int level;

    public Column (int idx, int level)
    {
      this.idx = idx;
      this.level = level;
    }
  }

  public int trap (int[] A)
  {
    if (A == null)
      return 0;
    int N = A.length;
    Stack<Column> stack = new Stack<Column>();
    int water = 0;
    for (int i = 0; i < N; ++i)
    {
      Column last = null;
      while (!stack.empty() && A[i] >= stack.peek().level)
      {
        if (last != null)
          water += (stack.peek().level - last.level) * (i - 1 - stack.peek().idx);
        last = stack.pop();
      }
      if (!stack.empty() && last != null)
        water += (A[i] - last.level) * (i - 1 - stack.peek().idx);
      stack.push(new Column(i, A[i]));
    }
    return water;
  }

}
