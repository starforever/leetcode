public class Solution
{
  public ListNode partition (ListNode head, int x)
  {
    ListNode h1 = null, t1 = null, h2 = null, t2 = null;
    ListNode p = head;
    while (p != null)
    {
      if (p.val < x)
      {
        if (t1 != null)
        {
          t1.next = p;
          t1 = p;
        }
        else
          h1 = t1 = p;
      }
      else
      {
        if (t2 != null)
        {
          t2.next = p;
          t2 = p;
        }
        else
          h2 = t2 = p;
      }
      p = p.next;
    }
    if (t2 != null)
      t2.next = null;
    if (t1 != null)
      t1.next = h2;
    return h1 != null ? h1 : h2;
  }
}
