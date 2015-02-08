public class Solution
{

  int lastVal;
  boolean isBST;

  void traverse (TreeNode p)
  {
    if (!isBST)
      return;
    if (p == null)
      return;
    traverse(p.left);
    if (p.val <= lastVal)
      isBST = false;
    lastVal = p.val;
    traverse(p.right);
  }

  public boolean isValidBST (TreeNode root)
  {
    lastVal = Integer.MIN_VALUE;
    isBST = true;
    traverse(root);
    return isBST;
  }

}
