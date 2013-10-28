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

  LinkedList<LinkedList<Integer>> findPath (TreeNode p, int sum)
  {
    LinkedList<LinkedList<Integer>> ret = new LinkedList<LinkedList<Integer>>();
    if (p == null)
      return ret;
    if (p.left == null && p.right == null)
    {
      if (p.val == sum)
        ret.add(new LinkedList(Arrays.asList(p.val)));
      return ret;
    }
    ret.addAll(findPath(p.left, sum - p.val));
    ret.addAll(findPath(p.right, sum - p.val));
    for (LinkedList<Integer> path : ret)
      path.addFirst(p.val);
    return ret;
  }

  public ArrayList<ArrayList<Integer>> pathSum (TreeNode root, int sum)
  {
    LinkedList<LinkedList<Integer>> pathList = findPath(root, sum);
    ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
    for (LinkedList<Integer> path : pathList)
      ret.add(new ArrayList<Integer>(path));
    return ret;
  }

}
