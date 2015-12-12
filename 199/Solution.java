public class Solution
{
  private void traverse (int dep, TreeNode p, ArrayList<Integer> list)
  {
    if (p == null)
      return;
    if (dep == list.size())
      list.add(p.val);
    else
      list.set(dep, p.val);
    traverse(dep + 1, p.left, list);
    traverse(dep + 1, p.right, list);
  }

  public List<Integer> rightSideView (TreeNode root)
  {
    ArrayList<Integer> list = new ArrayList<Integer>();
    traverse(0, root, list);
    return list;
  }
}
