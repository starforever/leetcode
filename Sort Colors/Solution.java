public class Solution
{

  int[] A;

  void swap (int a, int b)
  {
    int tmp = A[a];
    A[a] = A[b];
    A[b] = tmp;
  }

  public void sortColors (int[] A)
  {
    if (A == null)
      return;
    this.A = A;
    int n = A.length;
    int p0 = 0, p1 = 0, p2 = n - 1;
    while (p1 <= p2)
    {
      if (A[p1] == 0)
      {
        swap(p1, p0++);
        ++p1;
      }
      else if (A[p1] == 1)
        ++p1;
      else // A[p1] == 2
        swap(p1, p2--);
    }
  }

}
