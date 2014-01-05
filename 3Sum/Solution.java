public class Solution
{

  HashMap<Integer, Integer> calcNumCount (int[] num)
  {
    HashMap<Integer, Integer> numCount = new HashMap<Integer, Integer>();
    for (int i = 0; i < num.length; ++i)
    {
      if (!numCount.containsKey(num[i]))
        numCount.put(num[i], 1);
      else
        numCount.put(num[i], numCount.get(num[i]) + 1);
    }
    return numCount;
  }

  int unique (int[] num)
  {
    Arrays.sort(num);
    int i = 0;
    int n = 0;
    while (i < num.length)
    {
      num[n++] = num[i];
      int j = i + 1;
      while (j < num.length && num[j] == num[i])
        ++j;
      i = j;
    }
    return n;
  }

  public ArrayList<ArrayList<Integer>> threeSum (int[] num)
  {
    HashMap<Integer, Integer> numCount = calcNumCount(num);
    int N = unique(num);
    ArrayList<ArrayList<Integer>> solList = new ArrayList<ArrayList<Integer>>();
    for (int i = 0; i < N; ++i)
    {
      int a = num[i];
      for (int j = i + ((numCount.get(a) == 1) ? 1 : 0); j < N; ++j)
      {
        int b = num[j];
        int c = -(a + b);
        if (c < b)
          continue;
        if (!numCount.containsKey(c))
          continue;
        int leastCnt = 1 + ((c == b) ? 1 : 0) + ((c == a) ? 1 : 0);
        if (numCount.get(c) >= leastCnt)
          solList.add(new ArrayList<Integer>(Arrays.asList(a, b, c)));
      }
    }
    return solList;
  }

}
