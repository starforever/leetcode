public class Solution
{

  ArrayList<ListNode> lists;

  ListNode merge (int start, int end)
  {
    if (end - start == 1)
      return lists.get(start);
    int mid = (start + end) / 2;
    ListNode head1 = merge(start, mid), head2 = merge(mid, end);
    if (head1 == null)
      return head2;
    if (head2 == null)
      return head1;
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
    return head;
  }

  public ListNode mergeKLists (ArrayList<ListNode> lists)
  {
    if (lists == null || lists.isEmpty())
      return null;
    this.lists = lists;
    return merge(0, lists.size());
  }

}
