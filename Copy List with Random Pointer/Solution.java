/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *   int label;
 *   RandomListNode next, random;
 *   RandomListNode(int x) { this.label = x; }
 * };
 */

public class Solution
{
  public RandomListNode copyRandomList (RandomListNode head)
  {
    if (head == null)
      return null;
    for (RandomListNode p = head; p != null;)
    {
      RandomListNode r = new RandomListNode(p.label);
      r.next = p.next;
      r.random = p.random;
      p.next = r;
      p = r.next;
    }
    RandomListNode newHead = head.next;
    for (RandomListNode p = newHead; p != null; p = p.next != null ? p.next.next : null)
    {
      if (p.random != null)
        p.random = p.random.next;
    }
    for (RandomListNode p1 = head, p2 = newHead; p1 != null && p2 != null; p1 = p1.next, p2 = p2.next)
    {
      p1.next = p1.next.next;
      p2.next = p2.next != null ? p2.next.next : null;
    }
    return newHead;
  }
}
