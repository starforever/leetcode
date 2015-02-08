public class Solution
{

  static class InvalidExpression extends RuntimeException
  {
    public InvalidExpression ()
    {
    }
  }

  enum Operator {ADD, SUBTRACT, MULTIPLY, DIVIDE, UNKNOWN}

  Operator getOp (String token)
  {
    if (token.length() != 1)
      return Operator.UNKNOWN;
    char c = token.charAt(0);
    switch (c)
    {
      case '+':
        return Operator.ADD;
      case '-':
        return Operator.SUBTRACT;
      case '*':
        return Operator.MULTIPLY;
      case '/':
        return Operator.DIVIDE;
      default:
        return Operator.UNKNOWN;
    }
  }

  int eval (int a, int b, Operator op)
  {
    switch (op)
    {
      case ADD:
        return a + b;
      case SUBTRACT:
        return a - b;
      case MULTIPLY:
        return a * b;
      case DIVIDE:
        return a / b;
      default:
        return -1;
    }
  }

  public int evalRPN (String[] tokens)
  {
    Stack<Integer> stack = new Stack<Integer>();
    for (int i = 0; i < tokens.length; ++i)
    {
      Operator op = getOp(tokens[i]);
      if (op != Operator.UNKNOWN)
      {
        if (stack.size() < 2)
          throw new InvalidExpression();
        int b = stack.pop(), a = stack.pop();
        stack.push(eval(a, b, op));
      }
      else
      {
        try
        {
          stack.push(Integer.parseInt(tokens[i]));
        }
        catch (NumberFormatException e)
        {
          throw new InvalidExpression();
        }
      }
    }
    if (stack.size() != 1)
      throw new InvalidExpression();
    return stack.pop();
  }

}
