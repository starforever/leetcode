/**
 * Definition for singly-linked list.
 * public class ListNode {
 *   int val;
 *   ListNode next;
 *   ListNode(int x) { val = x; next = null; }
 * }
 */
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

  static class Result
  {
    TreeNode root;
    ListNode next;

    public Result (TreeNode root, ListNode next)
    {
      this.root = root;
      this.next = next;
    }
  }

  Result convert (ListNode cur, int len)
  {
    if (len == 0)
      return new Result(null, cur);
    if (len == 1)
      return new Result(new TreeNode(cur.val), cur.next);
    int len1 = len / 2, len2 = len - len1 - 1;
    Result r1 = convert(cur, len1);
    TreeNode p = new TreeNode(r1.next.val);
    Result r2 = convert(r1.next.next, len2);
    p.left = r1.root;
    p.right = r2.root;
    return new Result(p, r2.next);
  }

  int getLength (ListNode head)
  {
    int len = 0;
    while (head != null)
    {
      ++len;
      head = head.next;
    }
    return len;
  }

  public TreeNode sortedListToBST (ListNode head)
  {
    return convert(head, getLength(head)).root;
  }
}
