public class Solution
{

  int N;
  char[] cur;

  ArrayList<String> solList;

  void search (int idx, int numLeft, int numRight)
  {
    if (idx == N * 2)
    {
      solList.add(new String(cur));
      return;
    }
    if (numLeft < N)
    {
      cur[idx] = '(';
      search(idx + 1, numLeft + 1, numRight);
    }
    if (numRight < numLeft)
    {
      cur[idx] = ')';
      search(idx + 1, numLeft, numRight + 1);
    }
  }

  public ArrayList<String> generateParenthesis (int n)
  {
    solList = new ArrayList<String>();
    N = n;
    cur = new char[N * 2];
    search(0, 0, 0);
    return solList;
  }

}
