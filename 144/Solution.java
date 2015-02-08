public class Solution
{
  public ArrayList<Integer> preorderTraversal (TreeNode root)
  {
    ArrayList<Integer> ret = new ArrayList<Integer>();
    Stack<TreeNode> stack = new Stack<TreeNode>();
    if (root != null)
      stack.push(root);
    while (!stack.empty())
    {
      TreeNode p = stack.pop();
      ret.add(p.val);
      if (p.right != null)
        stack.push(p.right);
      if (p.left != null)
        stack.push(p.left);
    }
    return ret;
  }
}
