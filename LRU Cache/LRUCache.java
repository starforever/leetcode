public class LRUCache
{

  static class Node
  {
    int key;
    int value;
    Node next = null, prev = null;

    public Node (int key, int value)
    {
      this.key = key;
      this.value = value;
    }
  }

  int capacity, size = 0;
  Node head = null, tail = null;
  HashMap<Integer, Node> pos = new HashMap<Integer, Node>();

  public LRUCache (int capacity)
  {
    this.capacity = capacity;
  }

  public int get (int key)
  {
    if (!pos.containsKey(key))
      return -1;
    Node p = pos.get(key);
    remove(p);
    addFront(p);
    return p.value;
  }

  public void set (int key, int value)
  {
    Node p;
    if (pos.containsKey(key))
    {
      p = pos.get(key);
      p.value = value;
      remove(p);
    }
    else
    {
      p = new Node(key, value);
      pos.put(key, p);
      ++size;
      if (size > capacity)
      {
        pos.remove(tail.key);
        remove(tail);
        --size;
      }
    }
    addFront(p);
  }

  void remove (Node p)
  {
    if (p.prev != null)
      p.prev.next = p.next;
    else
      head = p.next;
    if (p.next != null)
      p.next.prev = p.prev;
    else
      tail = p.prev;
    p.next = p.prev = null;
  }

  void addFront (Node p)
  {
    if (head != null)
    {
      p.next = head;
      head.prev = p;
      head = p;
    }
    else
      head = tail = p;
  }

}
