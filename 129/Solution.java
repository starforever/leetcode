public class Solution
{

  int sum;

  void DFS (TreeNode p, int num)
  {
    num = num * 10 + p.val;
    if (p.left == null && p.right == null)
      sum += num;
    if (p.left != null)
      DFS(p.left, num);
    if (p.right != null)
      DFS(p.right, num);
  }

  public int sumNumbers (TreeNode root)
  {
    if (root == null)
      return 0;
    sum = 0;
    DFS(root, 0);
    return sum;
  }

}
