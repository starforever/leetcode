public class TwoSum
{
  private HashMap<Integer, Integer> numCount = new HashMap<Integer, Integer>();

  public void add (int number)
  {
    if (!numCount.containsKey(number))
      numCount.put(number, 1);
    else
      numCount.put(number, numCount.get(number) + 1);
  }

  public boolean find (int value)
  {
    for (int num : numCount.keySet())
    {
      long x = (long)value - (long)num;
      if (x >= Integer.MIN_VALUE && x <= Integer.MAX_VALUE && numCount.containsKey((int)x) && numCount.get((int)x) >= (x == num ? 2 : 1))
        return true;
    }
    return false;
  }
}
