public class Solution
{
  public boolean search (int[] A, int target)
  {
    if (A == null)
      return false;
    for (int i = 0; i < A.length; ++i)
      if (A[i] == target)
        return true;
    return false;
  }
}
