public class Solution
{
  public ListNode reverseBetween (ListNode head, int m, int n)
  {
    if (head == null)
      return null;
    ListNode prev = null, cur = head;
    for (int i = 1; i < m; ++i)
    {
      prev = cur;
      cur = cur.next;
    }
    ListNode before = prev, start = cur;
    prev = cur;
    cur = cur.next;
    for (int i = m + 1; i <= n; ++i)
    {
      ListNode tmp = cur.next;
      cur.next = prev;
      prev = cur;
      cur = tmp;
    }
    start.next = cur;
    if (before != null)
      before.next = prev;
    else
      head = prev;
    return head;
  }
}
