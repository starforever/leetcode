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
    if (root == null)
      return ret;
    LinkedList<State> stack = new LinkedList<State>();
    stack.add(new State(root));
    while (!stack.isEmpty())
    {
      State s = stack.getLast();
      switch (s.stage)
      {
        case 0:
          if (s.cur.left != null)
            stack.addLast(new State(s.cur.left));
          ++s.stage;
          break;
        case 1:
          ret.add(s.cur.val);
          if (s.cur.right != null)
            stack.addLast(new State(s.cur.right));
          ++s.stage;
          break;
        case 2:
          stack.removeLast();
          break;
      }
    }
    return ret;
  }
}
