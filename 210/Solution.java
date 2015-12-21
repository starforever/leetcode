public class Solution
{
  private LinkedList<Integer>[] adj;

  public int[] findOrder (int numCourses, int[][] prerequisites)
  {
    if (prerequisites == null)
      throw new IllegalArgumentException();
    LinkedList<Integer>[] adj = new LinkedList[numCourses];
    for (int i = 0; i < numCourses; ++i)
      adj[i] = new LinkedList<Integer>();
    int[] dep = new int[numCourses];
    for (int i = 0; i < numCourses; ++i)
      dep[i] = 0;
    for (int i = 0; i < prerequisites.length; ++i)
    {
      if (prerequisites[i].length < 2)
        throw new IllegalArgumentException();
      int a = prerequisites[i][0], b = prerequisites[i][1];
      adj[b].add(a);
      ++dep[a];
    }
    int[] order = new int[numCourses];
    int f = 0, e = 0;
    for (int i = 0; i < numCourses; ++i)
    {
      if (dep[i] == 0)
        order[e++] = i;
    }
    while (f < e)
    {
      int a = order[f++];
      for (int b : adj[a])
      {
        if (--dep[b] == 0)
          order[e++] = b;
      }
    }
    return e == numCourses ? order : new int[0];
  }
}
