public class Solution
{

  ListNode numList;

  ArrayList<ArrayList<Integer>> solList;
  Stack<Integer> curSol;

  ListNode buildList (int[] num)
  {
    ListNode head = new ListNode(0), tail = head;
    for (int i = 0; i < num.length; ++i)
      tail = tail.next = new ListNode(num[i]);
    return head;
  }

  void search ()
  {
    if (numList.next == null)
    {
      solList.add(new ArrayList<Integer>(curSol));
      return;
    }
    ListNode prev = numList, cur = prev.next;
    while (cur != null)
    {
      curSol.push(cur.val);
      prev.next = cur.next;
      search();
      prev.next = cur;
      curSol.pop();
      prev = cur;
      cur = cur.next;
    }
  }

  public ArrayList<ArrayList<Integer>> permute (int[] num)
  {
    solList = new ArrayList<ArrayList<Integer>>();
    if (num.length == 0)
      return solList;
    numList = buildList(num);
    curSol = new Stack<Integer>();
    search();
    return solList;
  }

}
