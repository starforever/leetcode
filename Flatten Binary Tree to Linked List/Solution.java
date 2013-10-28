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

  TreeNode flattenTree (TreeNode p)
  {
    if (p.left == null && p.right == null)
      return p;
    if (p.right == null)
    {
      p.right = p.left;
      p.left = null;
    }
    if (p.left == null)
      return flattenTree(p.right);
    TreeNode eL = flattenTree(p.left);
    TreeNode eR = flattenTree(p.right);
    eL.right = p.right;
    p.right = p.left;
    p.left = null;
    return eR;
  }

  public void flatten (TreeNode root)
  {
    if (root == null)
      return;
    flattenTree(root);
  }
}
