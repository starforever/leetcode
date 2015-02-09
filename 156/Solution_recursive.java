public class Solution
{
  public TreeNode UpsideDownBinaryTree (TreeNode root)
  {
    if (root == null)
      return null;
    if (root.left == null)
      return root;
    TreeNode newRoot = UpsideDownBinaryTree(root.left);
    root.left.left = root.right;
    root.left.right = root;
    root.left = root.right = null;
    return newRoot;
  }
}
