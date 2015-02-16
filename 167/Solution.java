public class Solution
{
  public int[] twoSum (int[] numbers, int target)
  {
    int j = numbers.length - 1;
    for (int i = 0; i < numbers.length; ++i)
    {
      while (j > i && numbers[j] + numbers[i] > target)
        --j;
      if (numbers[j] + numbers[i] == target)
        return new int[]{i + 1, j + 1};
    }
    return null;
  }
}
