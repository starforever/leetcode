public class Solution
{
  private LinkedList<Integer>[] adj;
  private boolean[] vis;
  private boolean[] inStack;

  private boolean DFS (int x)
  {
    vis[x] = true;
    inStack[x] = true;
    for (int y : adj[x])
    {
      if (inStack[y])
        return false;
      if (!vis[y] && !DFS(y))
        return false;
    }
    inStack[x] = false;
    return true;
  }

  public boolean canFinish (int numCourses, int[][] prerequisites)
  {
    adj = new LinkedList[numCourses];
    for (int i = 0; i < numCourses; ++i)
      adj[i] = new LinkedList<Integer>();
    for (int i = 0; i < prerequisites.length; ++i)
    {
      int a = prerequisites[i][0], b = prerequisites[i][1];
      adj[b].add(a);
    }
    
    vis = new boolean[numCourses];
    inStack = new boolean[numCourses];
    for (int i = 0; i < numCourses; ++i)
    {
      vis[i] = false;
      inStack[i] = false;
    }
    for (int i = 0; i < numCourses; ++i)
    {
      if (!vis[i] && !DFS(i))
        return false;
    }
    return true;
  }
}
