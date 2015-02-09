public class Solution
{
  public TreeNode UpsideDownBinaryTree (TreeNode root)
  {
    TreeNode curr = root, parent = null, sibling = null;
    while (curr != null)
    {
      TreeNode left = curr.left, right = curr.right;
      curr.left = sibling;
      curr.right = parent;
      parent = curr;
      sibling = right;
      curr = left;
    }
    return parent;
  }
}
