public class Solution
{
  public String simplifyPath (String path)
  {
    if (path == null)
      return null;
    LinkedList<String> cur = new LinkedList<String>();
    String[] parts = path.split("/");
    for (int i = 0; i < parts.length; ++i)
    {
      if (parts[i].isEmpty())
        continue;
      else if (parts[i].equals("."))
        continue;
      else if (parts[i].equals(".."))
      {
        if (!cur.isEmpty())
          cur.removeLast();
      }
      else
        cur.addLast(parts[i]);
    }
    if (cur.isEmpty())
      return "/";
    StringBuilder sb = new StringBuilder();
    for (String part : cur)
    {
      sb.append('/');
      sb.append(part);
    }
    return sb.toString();
  }
}
