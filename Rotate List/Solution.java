public class Solution
{
  public ListNode rotateRight (ListNode head, int k)
  {
    if (k == 0)
      return head;
    ListNode p1 = head, p2 = head;
    while (k > 0 && p2 != null)
    {
      p2 = p2.next;
      --k;
    }
    if (k > 0)
      return null;
    if (p2 == null)
      return head;
    while (p2.next != null)
    {
      p1 = p1.next;
      p2 = p2.next;
    }
    p2.next = head;
    head = p1.next;
    p1.next = null;
    return head;
  }
}
