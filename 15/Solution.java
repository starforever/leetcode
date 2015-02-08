public class Solution
{

  int unique (int[] num)
  {
    Arrays.sort(num);
    int i = 0, n = 0;
    while (i < num.length)
    {
      num[n++] = num[i];
      while (i < num.length && num[i] == num[n - 1])
        ++i;
    }
    return n;
  }

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
        int needC = 1 + ((c == b) ? 1 : 0) + ((c == a) ? 1 : 0);
        if (numCount.get(c) >= needC)
          solList.add(new ArrayList<Integer>(Arrays.asList(a, b, c)));
      }
    }
    return solList;
  }

}
