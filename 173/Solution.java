public class BSTIterator
{
  private Stack<TreeNode> stack;

  public BSTIterator (TreeNode root)
  {
    stack = new Stack<TreeNode>();
    pushLeftPath(root);
  }

  public boolean hasNext ()
  {
    return !stack.empty();
  }

  public int next ()
  {
    if (!hasNext())
      throw new RuntimeException("Stack is empty!");
    TreeNode p = stack.pop();
    pushLeftPath(p.right);
    return p.val;
  }

  private void pushLeftPath (TreeNode p)
  {
    while (p != null)
    {
      stack.push(p);
      p = p.left;
    }
  }
}
