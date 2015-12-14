public class Solution
{
  public ListNode reverseList (ListNode head)
  {
    if (head == null)
      return null;
    Stack<ListNode> stack = new Stack<ListNode>();
    ListNode p = head;
    while (p != null)
    {
      stack.push(p);
      p = p.next;
    }
    head = stack.pop();
    p = head;
    while (!stack.empty())
    {
      p.next = stack.pop();
      p = p.next;
    }
    p.next = null;
    return head;
  }
}
