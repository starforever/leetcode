public class Solution
{
  public ArrayList<Integer> postorderTraversal (TreeNode root)
  {
    ArrayList<Integer> ret = new ArrayList<Integer>();
    Stack<TreeNode> stack = new Stack<TreeNode>();
    TreeNode prev = null;
    if (root != null)
      stack.push(root);
    while (!stack.empty())
    {
      TreeNode cur = stack.peek();
      int flag;
      if (prev == null || prev.left == cur || prev.right == cur)
        flag = 0;
      else if (prev == cur.left)
        flag = 1;
      else // if (prev == cur.right)
        flag = 2;
      if (flag <= 0 && cur.left != null)
        stack.push(cur.left);
      else if (flag <= 1 && cur.right != null)
        stack.push(cur.right);
      else // if (flag <= 2)
      {
        ret.add(cur.val);
        stack.pop();
      }
      prev = cur;
    }
    return ret;
  }
}
