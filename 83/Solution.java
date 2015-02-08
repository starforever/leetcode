public class Solution
{
  public ListNode deleteDuplicates (ListNode head)
  {
    if (head == null)
      return null;
    ListNode prev = head, cur = head.next;
    while (cur != null)
    {
      if (cur.val == prev.val)
        prev.next = cur.next;
      else
        prev = cur;
      cur = cur.next;
    }
    return head;
  }
}
