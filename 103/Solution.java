public class Solution
{
  public ArrayList<ArrayList<Integer>> zigzagLevelOrder (TreeNode root)
  {
    ArrayList<ArrayList<Integer>> levelList = new ArrayList<ArrayList<Integer>>();
    if (root == null)
      return levelList;
    LinkedList<TreeNode> curLevel = new LinkedList<TreeNode>();
    curLevel.add(root);
    boolean straight = true;
    while (!curLevel.isEmpty())
    {
      ArrayList<Integer> row = new ArrayList<Integer>();
      for (TreeNode p : curLevel)
        row.add(p.val);
      levelList.add(row);
      LinkedList<TreeNode> nextLevel = new LinkedList<TreeNode>();
      Iterator<TreeNode> it = curLevel.descendingIterator();
      while (it.hasNext())
      {
        TreeNode p = it.next();
        TreeNode[] child = straight ? new TreeNode[]{p.right, p.left} : new TreeNode[]{p.left, p.right};
        for (int i = 0; i < child.length; ++i)
          if (child[i] != null)
            nextLevel.add(child[i]);
      }
      curLevel = nextLevel;
      straight = !straight;
    }
    return levelList;
  }
}
