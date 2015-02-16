public class TwoSum
{
  private HashSet<Integer> sumSet = new HashSet<Integer>();
  private ArrayList<Integer> numList = new ArrayList<Integer>();

  public void add (int number)
  {
    for (int i = 0; i < numList.size(); ++i)
    {
      long sum = (long)number + (long)numList.get(i);
      if (sum >= Integer.MIN_VALUE && sum <= Integer.MAX_VALUE)
        sumSet.add((int)sum);
    }
    numList.add(number);
  }

  public boolean find (int value)
  {
    return sumSet.contains(value);
  }
}
