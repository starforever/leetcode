public class Solution
{
  public ListNode reverseKGroup (ListNode head, int k)
  {
    if (k == 0)
      throw new RuntimeException();
    ListNode cur = head, last = null, next = head;
    int ahead = 0;
    while (ahead < k && next != null)
    {
      ++ahead;
      next = next.next;
    }
    while (ahead == k)
    {
      ListNode prev = cur, nlast = cur;
      cur = cur.next;
      while (cur != next)
      {
        ListNode ncur = cur.next;
        cur.next = prev;
        prev = cur;
        cur = ncur;
      }
      if (last != null)
        last.next = prev;
      else
        head = prev;
      last = nlast;
      ahead = 0;
      while (ahead < k && next != null)
      {
        ++ahead;
        next = next.next;
      }
    }
    if (last != null)
      last.next = cur;
    return head;
  }
}
