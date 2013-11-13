public class Solution
{

  int length (ListNode head)
  {
    int n = 0;
    while (head != null)
    {
      ++n;
      head = head.next;
    }
    return n;
  }

  public ListNode rotateRight (ListNode head, int k)
  {
    if (head == null)
      return null;
    int n = length(head);
    k %= n;
    if (k == 0)
      return head;
    ListNode p1 = head, p2 = head;
    while (k > 0)
    {
      p2 = p2.next;
      --k;
    }
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
