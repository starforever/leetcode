public class Solution
{
  private static final int SEQ_LEN = 10;

  public List<String> findRepeatedDnaSequences (String s)
  {
    if (s.length() < SEQ_LEN)
      return new ArrayList<String>();
    HashSet<String> seqSet = new HashSet<String>();
    HashSet<String> repeatSeqSet = new HashSet<String>();
    for (int i = 0; i + 10 <= s.length(); ++i)
    {
      String seq = s.substring(i, i + 10);
      if (seqSet.contains(seq))
        repeatSeqSet.add(seq);
      else
        seqSet.add(seq);
    }
    return new ArrayList<String>(repeatSeqSet);
  }
}
