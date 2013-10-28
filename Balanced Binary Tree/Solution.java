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

  boolean check;

  int getDepth (TreeNode p)
  {
    if (p == null)
      return 0;
    int dL = getDepth(p.left), dR = getDepth(p.right);
    if (Math.abs(dL - dR) > 1)
      check = false;
    return Math.max(dL, dR) + 1;
  }

  public boolean isBalanced (TreeNode root)
  {
    check = true;
    getDepth(root);
    return check;
  }
}
