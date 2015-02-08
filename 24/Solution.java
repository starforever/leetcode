public class Solution
{
  public ListNode swapPairs (ListNode head)
  {
    if (head == null || head.next == null)
      return head;
    ListNode cur = head.next.next, prev = head;
    head.next.next = head;
    head = head.next;
    while (cur != null && cur.next != null)
    {
      ListNode next = cur.next.next;
      prev.next = cur.next;
      cur.next.next = cur;
      prev = cur;
      cur = next;
    }
    prev.next = cur;
    return head;
  }
}
