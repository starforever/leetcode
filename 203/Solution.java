public class Solution
{
  public ListNode removeElements (ListNode head, int val)
  {
    while (head != null && head.val == val)
      head = head.next;
    if (head == null)
      return null;
    ListNode p = head.next, r = head;
    while (p != null)
    {
      if (p.val == val)
      {
        p = p.next;
        r.next = p;
      }
      else
      {
        r = p;
        p = p.next;
      }
    }
    return head;
  }
}
