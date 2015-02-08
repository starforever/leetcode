public class Solution
{
  public void connect (TreeLinkNode root)
  {
    if (root == null)
      return;
    TreeLinkNode currentLevel = root;
    while (currentLevel.left != null)
    {
      TreeLinkNode p = currentLevel;
      while (true)
      {
        p.left.next = p.right;
        if (p.next == null)
          break;
        p.right.next = p.next.left;
        p = p.next;
      }
      currentLevel = currentLevel.left;
    }
  }
}
