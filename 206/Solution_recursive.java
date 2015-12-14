public class Solution
{
  private ListNode reverse (ListNode p, ListNode r)
  {
    if (p == null)
      return r;
    ListNode ret = reverse(p.next, p);
    p.next = r;
    return ret;
  }

  public ListNode reverseList (ListNode head)
  {
    return reverse(head, null);
  }
}
