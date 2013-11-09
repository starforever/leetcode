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
      if (prev == null || prev.left == cur || prev.right == cur)
      {
        if (cur.left != null)
          stack.push(cur.left);
        else if (cur.right != null)
          stack.push(cur.right);
        else
        {
          ret.add(cur.val);
          stack.pop();
        }
      }
      else if (prev == cur.left)
      {
        if (cur.right != null)
          stack.push(cur.right);
        else
        {
          ret.add(cur.val);
          stack.pop();
        }
      }
      else // prev == cur.right
      {
        ret.add(cur.val);
        stack.pop();
      }
      prev = cur;
    }
    return ret;
  }
}
