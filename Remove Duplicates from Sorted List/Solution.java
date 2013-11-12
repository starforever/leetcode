public class Solution
{
  public ListNode deleteDuplicates (ListNode head)
  {
    if (head == null)
      return null;
    HashSet<Integer> set = new HashSet<Integer>();
    set.add(head.val);
    ListNode prev = head, cur = head.next;
    while (cur != null)
    {
      if (set.contains(cur.val))
      {
        prev.next = cur.next;
        cur = cur.next;
      }
      else
      {
        set.add(cur.val);
        prev = cur;
        cur = cur.next;
      }
    }
    return head;
  }
}
