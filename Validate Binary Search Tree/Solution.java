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

  boolean check (TreeNode p)
  {
    if (p.left != null)
    {
      if (p.left.val >= p.val)
        return false;
      if (!check(p.left))
        return false;
    }
    if (p.right != null)
    {
      if (p.right.val <= p.val)
        return false;
      if (!check(p.right))
        return false;
    }
    return true;
  }

  public boolean isValidBST (TreeNode root)
  {
    if (root == null)
      return true;
    return check(root);
  }

}
