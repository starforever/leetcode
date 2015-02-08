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

  public void reorderList (ListNode head)
  {
    if (head == null || head.next == null)
      return;

    ListNode slow = head, fast = head;
    ListNode slowPrev = null;
    while (fast != null)
    {
      slowPrev = slow;
      slow = slow.next;
      if (fast.next == null)
        break;
      fast = fast.next.next;
    }
    slowPrev.next = null;

    slowPrev = null;
    while (slow != null)
    {
      ListNode tmp = slow.next;
      slow.next = slowPrev;
      slowPrev = slow;
      slow = tmp;
    }

    ListNode p1 = head, p2 = slowPrev;
    while (p2 != null)
    {
      ListNode tmp = p1.next;
      p1.next = p2;
      p1 = tmp;
      tmp = p2.next;
      p2.next = p1;
      p2 = tmp;
    }
  }

}
