/**
 * Definition for singly-linked list.
 * class ListNode {
 *   int val;
 *   ListNode next;
 *   ListNode(int x) {
 *     val = x;
 *     next = null;
 *   }
 * }
 */

public class Solution
{
  public ListNode detectCycle (ListNode head)
  {
    if (head == null)
      return null;
    ListNode r1, r2;
    r1 = r2 = head;
    while (r2.next != null && r2.next.next != null)
    {
      r1 = r1.next;
      r2 = r2.next.next;
      if (r1 == r2)
        break;
    }
    if (r2.next == null || r2.next.next == null)
      return null;
    r1 = head;
    while (r1 != r2)
    {
      r1 = r1.next;
      r2 = r2.next;
    }
    return r1;
  }
}
