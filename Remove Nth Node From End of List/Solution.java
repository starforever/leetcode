public class Solution
{
  public ListNode removeNthFromEnd (ListNode head, int n)
  {
    ListNode slow = head, fast = head;
    while (n > 0 && fast != null)
    {
      --n;
      fast = fast.next;
    }
    if (fast == null)
      return head.next;
    fast = fast.next;
    while (fast != null)
    {
      fast = fast.next;
      slow = slow.next;
    }
    slow.next = slow.next.next;
    return head;
  }
}
