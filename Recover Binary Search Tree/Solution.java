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

  TreeNode last;
  TreeNode first, second;

  void DFS (TreeNode p)
  {
    if (p == null)
      return;
    DFS(p.left);
    if (last != null && p.val < last.val)
    {
      if (first == null)
      {
        first = last;
        second = p;
      }
      else
        second = p;
    }
    last = p;
    DFS(p.right);
  }

  public void recoverTree (TreeNode root)
  {
    last = first = second = null;
    DFS(root);
    if (first != null && second != null)
    {
      int temp = first.val;
      first.val = second.val;
      second.val = temp;
    }
  }

}
