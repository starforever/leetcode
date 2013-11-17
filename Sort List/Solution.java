public class Solution
{
  public ListNode sortList (ListNode head)
  {
    if (head == null)
      return null;
    if (head.next == null)
      return head;
    ListNode slow = head, fast = head;
    while (true)
    {
      fast = fast.next.next;
      if (fast == null || fast.next == null)
        break;
      slow = slow.next;
    }
    ListNode head1 = head, head2 = slow.next;
    slow.next = null;
    head1 = sortList(head1);
    head2 = sortList(head2);
    ListNode tail;
    if (head1.val < head2.val)
    {
      head = tail = head1;
      head1 = head1.next;
    }
    else
    {
      head = tail = head2;
      head2 = head2.next;
    }
    while (head1 != null && head2 != null)
    {
      if (head1.val < head2.val)
      {
        tail = tail.next = head1;
        head1 = head1.next;
      }
      else
      {
        tail = tail.next = head2;
        head2 = head2.next;
      }
    }
    if (head1 != null)
      tail.next = head1;
    else
      tail.next = head2;
    return head;
  }
}
