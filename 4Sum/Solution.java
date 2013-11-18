public class Solution
{

  int N;
  int[] num;

  int next (int i)
  {
    int j = i + 1;
    while (j < N && num[j] == num[i])
      ++j;
    return j;
  }

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

  HashMap<Integer, ArrayList<int[]>> calcSumPair ()
  {
    HashMap<Integer, ArrayList<int[]>> sumPair = new HashMap<Integer, ArrayList<int[]>>();
    for (int i = 0; i < N; i = next(i))
      for (int j = i + 1; j < N; j = next(j))
      {
        int x = num[i] + num[j];
        if (!sumPair.containsKey(x))
          sumPair.put(x, new ArrayList<int[]>());
        sumPair.get(x).add(new int[]{num[i], num[j]});
      }
    return sumPair;
  }

  public ArrayList<ArrayList<Integer>> fourSum (int[] num, int target)
  {
    N = num.length;
    this.num = num;
    Arrays.sort(num);
    HashMap<Integer, Integer> numCount = calcNumCount();
    HashMap<Integer, ArrayList<int[]>> sumPair = calcSumPair();
    ArrayList<ArrayList<Integer>> solList = new ArrayList<ArrayList<Integer>>();
    for (int i = 0; i < N; i = next(i))
    {
      int a = num[i];
      for (int j = i + 1; j < N; j = next(j))
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
          int needC, needD;
          if (c > b)
            needC = 1;
          else if (b > a)
            needC = 2;
          else
            needC = 3;
          if (d > c)
            needD = 1;
          else
            needD = needC + 1;
          if (numCount.get(c) >= needC && numCount.get(d) >= needD)
            solList.add(new ArrayList<Integer>(Arrays.asList(a, b, c, d)));
        }
      }
    }
    return solList;
  }

}
