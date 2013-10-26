public class Solution
{
  public int candy (int[] ratings)
  {
    int cnt = 1;
    int lastUp = 1, lastDown = 1;
    for (int i = 1; i < ratings.length; ++i)
    {
      if (ratings[i] > ratings[i - 1])
      {
        lastDown = 0;
        cnt += lastUp + 1;
        ++lastUp;
      }
      else if (ratings[i] < ratings[i - 1])
      {
        lastUp = 1;
        cnt += lastDown + 1;
        ++lastDown;
      }
      else
      {
        ++cnt;
        lastUp = lastDown = 1;
      }
    }
    return cnt;
  }
}
