import java.util.*;

public class Permutation
{

  void permutation (int n)
  {
    boolean[] used = new boolean[n];
    int[] stack = new int[n];
    int top = 0;
    stack[top] = -1;
    while (top >= 0)
    {
      int x = stack[top];
      if (x >= 0)
        used[x] = false;
      x++;
      while (x < n && used[x])
        x++;
      if (x == n)
        top--;
      else
      {
        stack[top] = x;
        used[x] = true;
        if (top == n - 1)
        {
          for (int i = 0; i < n; ++i)
            System.out.print(String.format("%d ", stack[i]));
          System.out.println();
        }
        else
          stack[++top] = -1;
      }
    }
  }

  public static void main (String[] args)
  {
    new Permutation().permutation(4);
  }

}
