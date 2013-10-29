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

  ArrayList<ArrayList<Integer>> levelList;

  void DFS (TreeNode p, int level)
  {
    if (p == null)
      return;
    if (level >= levelList.size())
      levelList.add(new ArrayList<Integer>());
    levelList.get(level).add(p.val);
    DFS(p.left, level + 1);
    DFS(p.right, level + 1);
  }

  public ArrayList<ArrayList<Integer>> levelOrderBottom (TreeNode root)
  {
    levelList = new ArrayList<ArrayList<Integer>>();
    DFS(root, 0);
    int n = levelList.size();
    for (int i = 0; i < n / 2; ++i)
    {
      int j = n - 1 - i;
      ArrayList<Integer> t = levelList.get(i);
      levelList.set(i, levelList.get(j));
      levelList.set(j, t);
    }
    return levelList;
  }

}
