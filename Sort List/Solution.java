public class Solution
{

  int length (ListNode head)
  {
    int len = 0;
    while (head != null)
    {
      ++len;
      head = head.next;
    }
    return len;
  }

  ListNode[] sortSegList (ListNode cur, int m)
  {
    ListNode head1 = cur, last = null;
    int cm = 0;
    while (cur != null && cm < m)
    {
      ++cm;
      last = cur;
      cur = cur.next;
    }
    if (cur == null)
      return new ListNode[]{head1, last, null};
    last.next = null;
    ListNode head2 = cur;
    cm = 0;
    last = null;
    while (cur != null && cm < m)
    {
      ++cm;
      last = cur;
      cur = cur.next;
    }
    last.next = null;
    ListNode next = cur;
    ListNode head, tail;
    if (head1.val < head2.val)
    {
      head = tail = head1;
      head1 = head1.next;
    }
    else
    {
      head = tail = head2;
      head2 = head2.next;
    }
    while (head1 != null && head2 != null)
    {
      if (head1.val < head2.val)
      {
        tail = tail.next = head1;
        head1 = head1.next;
      }
      else
      {
        tail = tail.next = head2;
        head2 = head2.next;
      }
    }
    if (head1 != null)
      tail.next = head1;
    else
      tail.next = head2;
    while (tail.next != null)
      tail = tail.next;
    return new ListNode[]{head, tail, next};
  }

  public ListNode sortList (ListNode head)
  {
    int n = length(head);
    int m = 1;
    while (m < n)
    {
      ListNode cur = head;
      head = null;
      ListNode tail = null;
      while (cur != null)
      {
        ListNode[] res = sortSegList(cur, m);
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
      tail.next = null;
      m *= 2;
    }
    return head;
  }

}
