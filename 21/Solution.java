public class Solution
{
  public ListNode mergeTwoLists (ListNode l1, ListNode l2)
  {
    if (l1 == null)
      return l2;
    if (l2 == null)
      return l1;
    ListNode head, tail;
    ListNode p1 = l1, p2 = l2;
    if (p1.val <= p2.val)
    {
      head = tail = p1;
      p1 = p1.next;
    }
    else
    {
      head = tail = p2;
      p2 = p2.next;
    }
    while (p1 != null && p2 != null)
    {
      if (p1.val <= p2.val)
      {
        tail = tail.next = p1;
        p1 = p1.next;
      }
      else
      {
        tail = tail.next = p2;
        p2 = p2.next;
      }
    }
    tail.next = p1 != null ? p1 : p2;
    return head;
  }
}
