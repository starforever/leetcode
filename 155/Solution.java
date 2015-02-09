class MinStack
{
  private Stack<Integer> mainStack = new Stack<Integer>();
  private Stack<Integer> minStack = new Stack<Integer>();

  public void push (int x)
  {
    mainStack.push(x);
    if (minStack.empty() || x <= (int)minStack.peek())
      minStack.push(x);
  }

  public void pop ()
  {
    if (mainStack.empty())
      throw new RuntimeException("Stack is empty!");
    if ((int)mainStack.peek() == (int)minStack.peek())
      minStack.pop();
    mainStack.pop();
  }

  public int top ()
  {
    if (mainStack.empty())
      throw new RuntimeException("Stack is empty!");
    return mainStack.peek();
  }

  public int getMin ()
  {
    if (mainStack.empty())
      throw new RuntimeException("Stack is empty!");
    return minStack.peek();
  }
}
