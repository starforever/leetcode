public class Solution
{
  public ArrayList<Integer> postorderTraversal (TreeNode root)
  {
    Stack<TreeNode> stack1 = new Stack<TreeNode>();
    Stack<TreeNode> stack2 = new Stack<TreeNode>();
    if (root != null)
      stack1.push(root);
    while (!stack1.empty())
    {
      TreeNode cur = stack1.pop();
      stack2.push(cur);
      if (cur.left != null)
        stack1.push(cur.left);
      if (cur.right != null)
        stack1.push(cur.right);
    }
    ArrayList<Integer> ret = new ArrayList<Integer>();
    while (!stack2.empty())
      ret.add(stack2.pop().val);
    return ret;
  }
}
