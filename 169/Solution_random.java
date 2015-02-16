import java.util.Random;

public class Solution
{
  public int majorityElement (int[] num)
  {
    if (num == null || num.length == 0)
      throw new IllegalArgumentException();
    Random rand = new Random();
    while (true)
    {
      int x = num[rand.nextInt(num.length)];
      int cnt = 0;
      for (int i = 0; i < num.length; ++i)
      {
        if (num[i] == x)
          ++cnt;
      }
      if (cnt > num.length / 2)
        return x;
    }
  }
}
