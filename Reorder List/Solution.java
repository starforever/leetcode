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

  int length (ListNode head)
  {
    int len = 0;
    while (head != null)
    {
      head = head.next;
      ++len;
    }
    return len;
  }

  ListNode reorder (ListNode head, int len)
  {
    if (len == 1)
    {
      ListNode ret = head.next;
      head.next = null;
      return ret;
    }
    if (len == 2)
    {
      ListNode ret = head.next.next;
      head.next.next = null;
      return ret;
    }
    ListNode tail = reorder(head.next, len - 2);
    ListNode ret = tail.next;
    tail.next = head.next;
    head.next = tail;
    return ret;
  }

  public void reorderList (ListNode head)
  {
    if (head == null)
      return;
    reorder(head, length(head));
  }

}
