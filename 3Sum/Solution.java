public class Solution
{

  int N;
  int[] num;

  HashMap<Integer, Integer> calcNumCount ()
  {
    HashMap<Integer, Integer> numCount = new HashMap<Integer, Integer>();
    for (int i = 0; i < N; ++i)
    {
      if (!numCount.containsKey(num[i]))
        numCount.put(num[i], 1);
      else
        numCount.put(num[i], numCount.get(num[i]) + 1);
    }
    return numCount;
  }

  int next (int i)
  {
    int j = i + 1;
    while (j < N && num[j] == num[i])
      ++j;
    return j;
  }

  public ArrayList<ArrayList<Integer>> threeSum (int[] num)
  {
    N = num.length;
    this.num = num;
    Arrays.sort(num);
    HashMap<Integer, Integer> numCount = calcNumCount();
    ArrayList<ArrayList<Integer>> solList = new ArrayList<ArrayList<Integer>>();
    for (int i = 0; i < N; i = next(i))
    {
      int a = num[i];
      for (int j = i + 1; j < N; j = next(j))
      {
        int b = num[j];
        int c = -(a + b);
        if (c < b)
          continue;
        if (!numCount.containsKey(c))
          continue;
        int leastCnt;
        if (c > b)
          leastCnt = 1;
        else if (b > a)
          leastCnt = 2;
        else
          leastCnt = 3;
        if (numCount.get(c) >= leastCnt)
          solList.add(new ArrayList<Integer>(Arrays.asList(a, b, c)));
      }
    }
    return solList;
  }

}
