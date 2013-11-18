public class Solution
{

  ListNode[] reverse (ListNode cur, int k)
  {
    ListNode head = cur, tail = null;
    while (k > 0 && cur != null)
    {
      --k;
      tail = cur;
      cur = cur.next;
    }
    if (k > 0)
      return new ListNode[]{head, tail, null};
    ListNode next = cur, prev = null;
    tail = cur = head;
    while (cur != next)
    {
      ListNode tmp = cur.next;
      cur.next = prev;
      prev = cur;
      cur = tmp;
    }
    head = prev;
    return new ListNode[]{head, tail, next};
  }

  public ListNode reverseKGroup (ListNode head, int k)
  {
    if (k == 0)
      return head;
    ListNode cur = head, tail = null;
    head = null;
    while (cur != null)
    {
      ListNode[] res = reverse(cur, k);
      if (head == null)
      {
        head = res[0];
        tail = res[1];
      }
      else
      {
        tail.next = res[0];
        tail = res[1];
      }
      cur = res[2];
    }
    return head;
  }

}
