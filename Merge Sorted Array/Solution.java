public class Solution
{
  public void merge (int A[], int m, int B[], int n)
  {
    int p = m + n - 1, p1 = m - 1, p2 = n - 1;
    while (p2 >= 0)
    {
      if (p1 >= 0 && A[p1] > B[p2])
        A[p--] = A[p1--];
      else
        A[p--] = B[p2--];
    }
  }
}
