public class Solution
{
  private int reduce (int n)
  {
    int sum = 0;
    int t;
    while (n > 0)
    {
      t = n % 10;
      sum += t * t;
      n /= 10;
    }
    return sum;
  }

  public boolean isHappy (int n)
  {
    if (n <= 0)
      throw new IllegalArgumentException();
    HashSet<Integer> cycle = new HashSet<Integer>();
    while (!cycle.contains(n))
    {
      cycle.add(n);
      n = reduce(n);
    }
    return n == 1;
  }
}
