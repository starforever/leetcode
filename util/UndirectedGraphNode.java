// Definition for undirected graph.
public class UndirectedGraphNode
{

  int label;
  ArrayList<UndirectedGraphNode> neighbors;

  public UndirectedGraphNode (int x)
  {
    label = x;
    neighbors = new ArrayList<UndirectedGraphNode>();
  }

}
