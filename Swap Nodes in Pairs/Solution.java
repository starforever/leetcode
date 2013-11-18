public class Solution
{
  public ListNode swapPairs (ListNode head)
  {
    ListNode cur = head, prev = null;
    while (cur != null && cur.next != null)
    {
      ListNode next = cur.next.next;
      if (prev == null)
        head = cur.next;
      else
        prev.next = cur.next;
      cur.next.next = cur;
      cur.next = next;
      prev = cur;
      cur = next;
    }
    return head;
  }
}
