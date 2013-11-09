public class Solution
{

  ArrayList<ArrayList<Integer>> levelList;

  void DFS (TreeNode p, int level)
  {
    if (p == null)
      return;
    if (level == levelList.size())
      levelList.add(new ArrayList<Integer>());
    levelList.get(level).add(p.val);
    DFS(p.left, level + 1);
    DFS(p.right, level + 1);
  }

  public ArrayList<ArrayList<Integer>> levelOrder (TreeNode root)
  {
    levelList = new ArrayList<ArrayList<Integer>>();
    DFS(root, 0);
    return levelList;
  }

}
