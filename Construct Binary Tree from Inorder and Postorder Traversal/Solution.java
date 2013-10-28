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
  int[] inorder;
  int[] postorder;

  HashMap<Integer, Integer> inPos;

  int postNext;

  void buildPos ()
  {
    inPos = new HashMap<Integer, Integer>();
    for (int i = 0; i < N; ++i)
      inPos.put(inorder[i], i);
  }

  TreeNode construct (int start, int end)
  {
    if (end - start == 0)
      return null;
    int cur = postorder[--postNext];
    TreeNode root = new TreeNode(cur);
    int mid = inPos.get(cur);
    root.right = construct(mid + 1, end);
    root.left = construct(start, mid);
    return root;
  }

  public TreeNode buildTree (int[] inorder, int[] postorder)
  {
    if (inorder == null || postorder == null)
      return null;
    N = inorder.length;
    this.inorder = inorder;
    this.postorder = postorder;
    buildPos();
    postNext = N;
    return construct(0, N);
  }

}
