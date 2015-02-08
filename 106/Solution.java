public class Solution
{

  int N;
  int[] inorder;
  int[] postorder;

  HashMap<Integer, Integer> pos;
  int next;

  void buildPos ()
  {
    pos = new HashMap<Integer, Integer>();
    for (int i = 0; i < N; ++i)
      pos.put(inorder[i], i);
  }

  TreeNode construct (int start, int end)
  {
    if (end - start == 0)
      return null;
    int cur = postorder[next--];
    TreeNode root = new TreeNode(cur);
    int mid = pos.get(cur);
    root.right = construct(mid + 1, end);
    root.left = construct(start, mid);
    return root;
  }

  public TreeNode buildTree (int[] inorder, int[] postorder)
  {
    N = inorder.length;
    this.inorder = inorder;
    this.postorder = postorder;
    buildPos();
    next = N - 1;
    return construct(0, N);
  }

}
