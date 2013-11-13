public class Solution
{
  public ListNode insertionSortList (ListNode head)
  {
    ListNode cur = head, prev = null;
    while (cur != null)
    {
      ListNode cur2 = head, prev2 = null;
      while (cur2 != cur && cur2.val < cur.val)
      {
        prev2 = cur2;
        cur2 = cur2.next;
      }
      if (cur2 == cur)
      {
        prev = cur;
        cur = cur.next;
        continue;
      }
      if (prev2 != null)
        prev2.next = cur;
      else
        head = cur;
      prev.next = cur.next;
      cur.next = cur2;
      cur = prev.next;
    }
    return head;
  }
}
