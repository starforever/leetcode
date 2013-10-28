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

  TreeNode convert (int[] num, int start, int end)
  {
    if (end - start == 0)
      return null;
    int mid = (start + end) / 2;
    TreeNode root = new TreeNode(num[mid]);
    root.left = convert(num, start, mid);
    root.right = convert(num, mid + 1, end);
    return root;
  }

  public TreeNode sortedArrayToBST (int[] num)
  {
    if (num == null)
      return null;
    return convert(num, 0, num.length);
  }

}
