/**
 * Definition for binary tree
 * public class TreeNode {
 *   int val;
 *   TreeNode left;
 *   TreeNode right;
 *   TreeNode(int x) { val = x; }
 * }
 */

public class Solution
{

  static class State
  {
    boolean mark = false;
    TreeNode node;

    public State (TreeNode node)
    {
      this.node = node;
    }
  }

  public ArrayList<Integer> postorderTraversal (TreeNode root)
  {
    ArrayList<Integer> ret = new ArrayList<Integer>();
    Stack<State> stack = new Stack<State>();
    if (root != null)
      stack.push(new State(root));
    while (!stack.empty())
    {
      State s = stack.peek();
      if (!s.mark)
      {
        if (s.node.right != null)
          stack.push(new State(s.node.right));
        if (s.node.left != null)
          stack.push(new State(s.node.left));
        s.mark = true;
      }
      else
      {
        ret.add(s.node.val);
        stack.pop();
      }
    }
    return ret;
  }

}
