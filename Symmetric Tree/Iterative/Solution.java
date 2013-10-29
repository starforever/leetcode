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

  boolean equalNode (TreeNode p, TreeNode q)
  {
    if (p == null && q == null)
      return true;
    if (p == null || q == null)
      return false;
    return p.val == q.val;
  }

  public boolean isSymmetric (TreeNode root)
  {
    if (root == null)
      return true;
    if (!equalNode(root.left, root.right))
      return false;
    if (root.left == null)
      return true;
    LinkedList<TreeNode> curLeft = new LinkedList<TreeNode>(), curRight = new LinkedList<TreeNode>();
    curLeft.add(root.left);
    curRight.add(root.right);
    while (!curLeft.isEmpty() && !curRight.isEmpty())
    {
      LinkedList<TreeNode> nextLeft = new LinkedList<TreeNode>(), nextRight = new LinkedList<TreeNode>();
      while (!curLeft.isEmpty() && !curRight.isEmpty())
      {
        TreeNode p = curLeft.remove(), q = curRight.remove();
        if (!(equalNode(p.left, q.right) && equalNode(p.right, q.left)))
          return false;
        if (p.left != null)
        {
          nextLeft.add(p.left);
          nextRight.add(q.right);
        }
        if (p.right != null)
        {
          nextLeft.add(p.right);
          nextRight.add(q.left);
        }
      }
      curLeft = nextLeft;
      curRight = nextRight;
    }
    return true;
  }

}
