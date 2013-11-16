public class Solution
{

  static class State
  {
    int idx;
    int step;

    public State (int idx, int step)
    {
      this.idx = idx;
      this.step = step;
    }
  }

  public int jump (int[] A)
  {
    if (A == null || A.length == 0)
      return -1;
    int N = A.length;
    Stack<State> stack = new Stack<State>();
    stack.push(new State(N - 1, 0));
    for (int i = N - 2; i >= 0; --i)
    {
      State last = null;
      while (!stack.empty() && stack.peek().idx - i <= A[i])
        last = stack.pop();
      if (last == null)
        continue;
      stack.push(last);
      stack.push(new State(i, last.step + 1));
    }
    if (!stack.empty() && stack.peek().idx == 0)
      return stack.peek().step;
    return -1;
  }

}
