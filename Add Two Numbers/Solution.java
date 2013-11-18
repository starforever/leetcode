public class Solution
{
  public ListNode addTwoNumbers (ListNode l1, ListNode l2)
  {
    if (l1 == null)
      return l2;
    if (l2 == null)
      return l1;
    ListNode head = null, tail = null;
    int x = 0;
    while (l1 != null && l2 != null)
    {
      x += l1.val + l2.val;
      if (head == null)
        head = tail = new ListNode(x % 10);
      else
        tail = tail.next = new ListNode(x % 10);
      x /= 10;
      l1 = l1.next;
      l2 = l2.next;
    }
    ListNode l = l1 != null ? l1 : l2;
    while (l != null)
    {
      x += l.val;
      tail = tail.next = new ListNode(x % 10);
      x /= 10;
      l = l.next;
    }
    if (x > 0)
      tail = tail.next = new ListNode(x);
    return head;
  }
}
