public class Solution
{
  public ArrayList<Integer> inorderTraversal (TreeNode root)
  {
    ArrayList<Integer> ret = new ArrayList<Integer>();
    Stack<TreeNode> stack = new Stack<TreeNode>();
    if (root != null)
      stack.push(root);
    while (!stack.empty())
    {
      while (stack.peek().left != null)
        stack.push(stack.peek().left);
      while (!stack.empty() && stack.peek().right == null)
        ret.add(stack.pop().val);
      if (!stack.empty())
      {
        ret.add(stack.peek().val);
        stack.push(stack.pop().right);
      }
    }
    return ret;
  }
}
