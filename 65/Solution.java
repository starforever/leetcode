public class Solution
{

  static enum Token
  {
    SIGN,
    DIGIT,
    DOT,
    EXPONENTIAL,
    INVALID;

    static Token fromChar (char c)
    {
      if (c == '+' || c == '-')
        return SIGN;
      else if (c >= '0' && c <= '9')
        return DIGIT;
      else if (c == '.')
        return DOT;
      else if (c == 'e' || c == 'E')
        return EXPONENTIAL;
      else
        return INVALID;
    }
  }

  static class Node
  {
    boolean finish;
    HashMap<Token, Node> next = new HashMap<Token, Node>();
  }

  static class Edge
  {
    int a, b;
    Token t;

    public Edge (int a, int b, Token t)
    {
      this.a = a;
      this.b = b;
      this.t = t;
    }
  }

  static final Edge[] EDGES = new Edge[]
  {
    new Edge(0, 1, Token.SIGN),
    new Edge(0, 2, Token.DIGIT),
    new Edge(0, 8, Token.DOT),
    new Edge(1, 2, Token.DIGIT),
    new Edge(1, 8, Token.DOT),
    new Edge(2, 2, Token.DIGIT),
    new Edge(2, 3, Token.DOT),
    new Edge(2, 5, Token.EXPONENTIAL),
    new Edge(3, 4, Token.DIGIT),
    new Edge(3, 5, Token.EXPONENTIAL),
    new Edge(4, 4, Token.DIGIT),
    new Edge(4, 5, Token.EXPONENTIAL),
    new Edge(5, 6, Token.SIGN),
    new Edge(5, 7, Token.DIGIT),
    new Edge(6, 7, Token.DIGIT),
    new Edge(7, 7, Token.DIGIT),
    new Edge(8, 4, Token.DIGIT)
  };

  static final int NUM_NODE = 9;
  static final int[] FINISH_NODE = new int[]{2, 3, 4, 7};

  static Node start = buildDFA();

  static Node buildDFA ()
  {
    Node[] nodes = new Node[NUM_NODE];
    for (int i = 0; i < NUM_NODE; ++i)
      nodes[i] = new Node();
    for (int i = 0; i < EDGES.length; ++i)
    {
      Edge e = EDGES[i];
      nodes[e.a].next.put(e.t, nodes[e.b]);
    }
    for (int i = 0; i < FINISH_NODE.length; ++i)
      nodes[FINISH_NODE[i]].finish = true;
    return nodes[0];
  }

  public boolean isNumber (String s)
  {
    s = s.trim();
    Node p = start;
    for (int i = 0; i < s.length(); ++i)
    {
      Token t = Token.fromChar(s.charAt(i));
      if (!p.next.containsKey(t))
        return false;
      p = p.next.get(t);
    }
    return p.finish;
  }
}
