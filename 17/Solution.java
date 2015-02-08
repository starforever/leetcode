public class Solution
{

  String[] DIGIT_LETTER = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

  int N;
  int[] index;
  char[] cur;

  ArrayList<String> solList;

  void search (int i)
  {
    if (i == N)
    {
      solList.add(new String(cur));
      return;
    }
    String letters = DIGIT_LETTER[index[i]];
    for (int j = 0; j < letters.length(); ++j)
    {
      cur[i] = letters.charAt(j);
      search(i + 1);
    }
  }

  public ArrayList<String> letterCombinations (String digits)
  {
    solList = new ArrayList<String>();
    N = digits.length();
    index = new int[N];
    for (int i = 0; i < N; ++i)
      index[i] = digits.charAt(i) - '2';
    cur = new char[N];
    search(0);
    return solList;
  }

}
