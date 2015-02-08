public class Solution
{
  public ListNode deleteDuplicates (ListNode head)
  {
    ListNode prev = null, cur = head;
    head = null;
    while (cur != null)
    {
      if (cur.next != null && cur.next.val == cur.val)
      {
        int curVal = cur.val;
        while (cur != null && cur.val == curVal)
          cur = cur.next;
        if (prev != null)
          prev.next = cur;
      }
      else
      {
        if (prev == null)
          head = cur;
        prev = cur;
        cur = cur.next;
      }
    }
    return head;
  }
}
