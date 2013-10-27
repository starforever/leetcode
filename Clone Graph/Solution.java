/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *   int label;
 *   ArrayList<UndirectedGraphNode> neighbors;
 *   UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */

public class Solution
{

  UndirectedGraphNode BFS (UndirectedGraphNode start)
  {
    HashMap<Integer, UndirectedGraphNode> nodeTable = new HashMap<Integer, UndirectedGraphNode>();
    LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
    queue.add(start);
    nodeTable.put(start.label, new UndirectedGraphNode(start.label));
    while (!queue.isEmpty())
    {
      UndirectedGraphNode p1 = queue.remove();
      UndirectedGraphNode p2 = nodeTable.get(p1.label);
      for (UndirectedGraphNode u1 : p1.neighbors)
      {
        if (!nodeTable.containsKey(u1.label))
        {
          queue.add(u1);
          nodeTable.put(u1.label, new UndirectedGraphNode(u1.label));
        }
        UndirectedGraphNode u2 = nodeTable.get(u1.label);
        p2.neighbors.add(u2);
      }
    }
    return nodeTable.get(start.label);
  }

  public UndirectedGraphNode cloneGraph (UndirectedGraphNode node)
  {
    if (node == null)
      return null;
    return BFS(node);
  }
}
