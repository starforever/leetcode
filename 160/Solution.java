public class Solution
{
  private ListNode getIntersectionNode (ListNode start)
  {
    ListNode p1 = start, p2 = start;
    do
    {
      p1 = p1.next;
      if (p2.next == null || p2.next.next == null)
        return null;
      p2 = p2.next.next;
    }
    while (p1 != p2);
    p1 = start;
    while (p1 != p2)
    {
      p1 = p1.next;
      p2 = p2.next;
    }
    return p1;
  }

  public ListNode getIntersectionNode (ListNode headA, ListNode headB)
  {
    if (headA == null || headB == null)
      return null;
    ListNode tailA = headA;
    while (tailA.next != null)
      tailA = tailA.next;
    tailA.next = headA;
    ListNode ret = getIntersectionNode(headB);
    tailA.next = null;
    return ret;
  }
}
