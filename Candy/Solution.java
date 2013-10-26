public class Solution
{

  static class Child implements Comparable<Child>
  {
    int rating;
    int pos;

    public Child (int rating, int pos)
    {
      this.rating = rating;
      this.pos = pos;
    }

    public int compareTo (Child o)
    {
      if (rating < o.rating)
        return -1;
      else if (rating > o.rating)
        return 1;
      else
        return 0;
    }
  }

  public int candy (int[] ratings)
  {
    int n = ratings.length;
    Child[] children = new Child[n];
    for (int i = 0; i < n; ++i)
      children[i] = new Child(ratings[i], i);
    Arrays.sort(children);
    int[] candy = new int[n];
    for (int i = 0; i < n; ++i)
    {
      int p = children[i].pos;
      int c = 0;
      if (p - 1 >= 0 && ratings[p - 1] < ratings[p])
        c = Math.max(c, candy[p - 1]);
      if (p + 1 < n && ratings[p + 1] < ratings[p])
        c = Math.max(c, candy[p + 1]);
      candy[p] = c + 1;
    }
    int sum = 0;
    for (int i = 0; i < n; ++i)
      sum += candy[i];
    return sum;
  }
}
