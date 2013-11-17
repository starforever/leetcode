public class Solution
{

  int[] num;

  void swap (int i, int j)
  {
    int tmp = num[i];
    num[i] = num[j];
    num[j] = tmp;
  }

  void reverse (int start, int end)
  {
    for (int i = 0; i < (end - start) / 2; ++i)
      swap(start + i, end - 1 - i);
  }

  public void nextPermutation (int[] num)
  {
    if (num == null || num.length < 2)
      return;
    this.num = num;
    int N = num.length;
    int i = N - 2;
    while (i >= 0 && num[i] >= num[i + 1])
      --i;
    if (i >= 0)
    {
      int j = i + 1;
      while (j < N && num[j] > num[i])
        ++j;
      --j;
      swap(i, j);
    }
    reverse(i + 1, N);
  }

}
