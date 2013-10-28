public class Solution
{
  public ArrayList<Integer> getRow (int rowIndex)
  {
    int[] row = new int[rowIndex + 1];
    row[0] = 1;
    for (int i = 1; i <= rowIndex; ++i)
    {
      row[i] = 1;
      for (int j = i - 1; j >= 1; --j)
        row[j] = row[j - 1] + row[j];
      row[0] = 1;
    }
    ArrayList<Integer> ret = new ArrayList<Integer>();
    for (int i = 0; i <= rowIndex; ++i)
      ret.add(row[i]);
    return ret;
  }
}
