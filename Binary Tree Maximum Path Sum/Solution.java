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

  int maxPath;

  int DFS (TreeNode p)
  {
    int vL = 0, vR = 0;
    if (p.left != null)
      vL = DFS(p.left);
    if (p.right != null)
      vR = DFS(p.right);
    maxPath = Math.max(maxPath, Math.max(vL, 0) + Math.max(vR, 0) + p.val);
    return Math.max(Math.max(vL, vR), 0) + p.val;
  }

  public int maxPathSum (TreeNode root)
  {
    if (root == null)
      return 0;
    maxPath = Integer.MIN_VALUE;
    DFS(root);
    return maxPath;
  }

}
