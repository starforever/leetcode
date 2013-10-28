public class Solution
{
  public ArrayList<ArrayList<Integer>> generate (int numRows)
  {
    ArrayList<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>>();
    if (numRows == 0)
      return triangle;
    triangle.add(new ArrayList<Integer>(Arrays.asList(1)));
    ArrayList<Integer> last = triangle.get(0);
    for (int i = 1; i < numRows; ++i)
    {
      ArrayList<Integer> row = new ArrayList<Integer>();
      row.add(1);
      for (int j = 1; j <= i - 1; ++j)
        row.add(last.get(j - 1) + last.get(j));
      row.add(1);
      triangle.add(row);
      last = row;
    }
    return triangle;
  }
}
