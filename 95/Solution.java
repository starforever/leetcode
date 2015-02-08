public class Solution
{

  ArrayList<TreeNode> generate (int start, int end)
  {
    ArrayList<TreeNode> ret = new ArrayList<TreeNode>();
    if (start == end)
    {
      ret.add(null);
      return ret;
    }
    for (int cur = start; cur < end; ++cur)
    {
      ArrayList<TreeNode> leftList = generate(start, cur), rightList = generate(cur + 1, end);
      for (TreeNode left : leftList)
        for (TreeNode right : rightList)
        {
          TreeNode root = new TreeNode(cur);
          root.left = left;
          root.right = right;
          ret.add(root);
        }
    }
    return ret;
  }

  public ArrayList<TreeNode> generateTrees (int n)
  {
    return generate(1, n + 1);
  }

}
