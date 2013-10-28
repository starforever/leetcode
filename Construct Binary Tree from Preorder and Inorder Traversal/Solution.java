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

  int N;
  int[] preorder;
  int[] inorder;

  HashMap<Integer, Integer> pos;

  int next;

  TreeNode construct (int start, int end)
  {
    if (end - start == 0)
      return null;
    int cur = preorder[next++];
    TreeNode root = new TreeNode(cur);
    int mid = pos.get(cur);
    root.left = construct(start, mid);
    root.right = construct(mid + 1, end);
    return root;
  }

  void buildPos ()
  {
    pos = new HashMap<Integer, Integer>();
    for (int i = 0; i < N; ++i)
      pos.put(inorder[i], i);
  }

  public TreeNode buildTree (int[] preorder, int[] inorder)
  {
    if (preorder == null || inorder == null)
      return null;
    N = preorder.length;
    this.preorder = preorder;
    this.inorder = inorder;
    buildPos();
    next = 0;
    return construct(0, N);
  }
}
