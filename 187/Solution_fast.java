import java.util.BitSet;

public class Solution
{
  private static final int SEQ_LEN = 10;
  private static final int MASK = (1 << SEQ_LEN * 2) - 1;

  public List<String> findRepeatedDnaSequences (String s)
  {
    if (s.length() < SEQ_LEN)
      return new ArrayList<String>();
    int hashCode = 0;
    for (int i = 0; i < SEQ_LEN; ++i)
      hashCode = hashCode << 2 | getCharCode(s.charAt(i));
    List<String> ret = new ArrayList<String>();
    BitSet seqSet = new BitSet(1 << SEQ_LEN * 2);
    BitSet resSet = new BitSet(1 << SEQ_LEN * 2);
    seqSet.set(hashCode);
    for (int i = 1; i + SEQ_LEN <= s.length(); ++i)
    {
      hashCode = (hashCode << 2 | getCharCode(s.charAt(i + SEQ_LEN - 1))) & MASK;
      if (seqSet.get(hashCode))
      {
        if (!resSet.get(hashCode))
        {
          resSet.set(hashCode);
          ret.add(s.substring(i, i + SEQ_LEN));
        }
      }
      else
      {
        seqSet.set(hashCode);
      }
    }
    return ret;
  }

  private int getCharCode (char c)
  {
    switch (c)
    {
      case 'A':
        return 0;
      case 'C':
        return 1;
      case 'G':
        return 2;
      case 'T':
        return 3;
      default:
        throw new IllegalArgumentException();
    }
  }
}
