public class Solution
{

  static class Result
  {
    TreeLinkNode next;
    TreeLinkNode nextPar;

    public Result (TreeLinkNode next, TreeLinkNode nextPar)
    {
      this.next = next;
      this.nextPar = nextPar;
    }
  }

  Result findNext (TreeLinkNode p)
  {
    while (p != null)
    {
      if (p.left != null)
        return new Result(p.left, p);
      else if (p.right != null)
        return new Result(p.right, p);
      else
        p = p.next;
    }
    return null;
  }

  public void connect (TreeLinkNode root)
  {
    if (root == null)
      return;
    TreeLinkNode currentLevel = root;
    while (true)
    {
      TreeLinkNode p = currentLevel;
      Result r = findNext(p);
      if (r == null)
        break;
      TreeLinkNode nextLevel = r.next;
      p = r.nextPar;
      TreeLinkNode u = nextLevel;
      while (true)
      {
        if (p.left == u && p.right != null)
        {
          u.next = p.right;
          u = u.next;
        }
        p = p.next;
        r = findNext(p);
        if (r == null)
          break;
        u.next = r.next;
        u = u.next;
        p = r.nextPar;
      }
      currentLevel = nextLevel;
    }
  }

}
