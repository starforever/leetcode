public class Solution
{

  int N;
  int[] num;
  HashMap<Integer, Integer> numCount;
  HashMap<Integer, ArrayList<int[]>> sumPair;

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

  HashMap<Integer, Integer> calcNumCount ()
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

  HashMap<Integer, ArrayList<int[]>> calcSumPair ()
  {
    HashMap<Integer, ArrayList<int[]>> sumPair = new HashMap<Integer, ArrayList<int[]>>();
    for (int i = 0; i < N; ++i)
    {
      int a = num[i];
      for (int j = i + (numCount.get(a) == 1 ? 1 : 0); j < N; ++j)
      {
        int b = num[j];
        int x = a + b;
        if (!sumPair.containsKey(x))
          sumPair.put(x, new ArrayList<int[]>());
        sumPair.get(x).add(new int[]{a, b});
      }
    }
    return sumPair;
  }

  public ArrayList<ArrayList<Integer>> fourSum (int[] num, int target)
  {
    this.num = num;
    numCount = calcNumCount();
    N = unique(num);
    sumPair = calcSumPair();
    ArrayList<ArrayList<Integer>> solList = new ArrayList<ArrayList<Integer>>();
    for (int i = 0; i < N; ++i)
    {
      int a = num[i];
      for (int j = i + (numCount.get(a) == 1 ? 1 : 0); j < N; ++j)
      {
        int b = num[j];
        int x = target - (a + b);
        if (!sumPair.containsKey(x))
          continue;
        for (int[] cd : sumPair.get(x))
        {
          int c = cd[0], d = cd[1];
          if (c < b)
            continue;
          int needC = 1 + ((c == b) ? 1 : 0) + ((c == a) ? 1 : 0);
          int needD = 1 + ((d == c) ? needC : 0);
          if (numCount.get(c) >= needC && numCount.get(d) >= needD)
            solList.add(new ArrayList<Integer>(Arrays.asList(a, b, c, d)));
        }
      }
    }
    return solList;
  }

}
