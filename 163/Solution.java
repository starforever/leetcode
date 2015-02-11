public class Solution
{
  private String getRangeString (int lower, int upper)
  {
    if (lower < upper)
      return String.format("%d->%d", lower, upper);
    else
      return String.valueOf(lower);
  }

  public List<String> findMissingRanges (int[] A, int lower, int upper)
  {
    if (A == null)
      throw new IllegalArgumentException();
    List<String> ranges = new LinkedList<String>();
    if (A.length == 0)
    {
      ranges.add(getRangeString(lower, upper));
      return ranges;
    }
    if (A[0] > lower)
      ranges.add(getRangeString(lower, A[0] - 1));
    for (int i = 0; i + 1 < A.length; ++i)
    {
      if (A[i + 1] - A[i] > 1)
        ranges.add(getRangeString(A[i] + 1, A[i + 1] - 1));
    }
    if (A[A.length - 1] < upper)
      ranges.add(getRangeString(A[A.length - 1] + 1, upper));
    return ranges;
  }
}
