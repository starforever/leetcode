public class Solution
{

  char getPair (char c)
  {
    switch (c)
    {
      case ')':
        return '(';
      case '}':
        return '{';
      case ']':
        return '[';
      default:
        return '?';
    }
  }

  public boolean isValid (String s)
  {
    Stack<Character> open = new Stack<Character>();
    for (int i = 0; i < s.length(); ++i)
    {
      char c = s.charAt(i);
      if (c == '(' || c == '{' || c == '[')
        open.push(c);
      else
      {
        if (open.empty())
          return false;
        char t = open.pop();
        if (t != getPair(c))
          return false;
      }
    }
    return open.empty();
  }

}
