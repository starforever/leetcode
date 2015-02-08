public class Solution
{

  static class State
  {
    int stage = 0;
    TreeNode cur;

    public State (TreeNode cur)
    {
      this.cur = cur;
    }
  }

  public ArrayList<Integer> inorderTraversal (TreeNode root)
  {
    ArrayList<Integer> ret = new ArrayList<Integer>();
    Stack<State> stack = new Stack<State>();
    if (root != null)
      stack.push(new State(root));
    while (!stack.empty())
    {
      State s = stack.peek();
      switch (s.stage)
      {
        case 0:
          if (s.cur.left != null)
            stack.push(new State(s.cur.left));
          ++s.stage;
          break;
        case 1:
          ret.add(s.cur.val);
          if (s.cur.right != null)
            stack.push(new State(s.cur.right));
          ++s.stage;
          break;
        case 2:
          stack.pop();
          break;
      }
    }
    return ret;
  }

}
