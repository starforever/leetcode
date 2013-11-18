public class Solution
{
  public int[] twoSum (int[] numbers, int target)
  {
    HashMap<Integer, Integer> numPos = new HashMap<Integer, Integer>();
    for (int i = 0; i < numbers.length; ++i)
    {
      if (numPos.containsKey(target - numbers[i]))
        return new int[]{numPos.get(target - numbers[i]) + 1, i + 1};
      numPos.put(numbers[i], i);
    }
    return null;
  }
}
