public class Solution
{
  private static final int SEQ_LEN = 10;

  public List<String> findRepeatedDnaSequences (String s)
  {
    if (s.length() < SEQ_LEN)
      return new ArrayList<String>();
    HashSet<SubString> seqSet = new HashSet<SubString>();
    HashSet<SubString> repeatSeqSet = new HashSet<SubString>();
    for (int i = 0; i + SEQ_LEN <= s.length(); ++i)
    {
      SubString seq = new SubString(s, i, i + SEQ_LEN);
      if (seqSet.contains(seq))
        repeatSeqSet.add(seq);
      else
        seqSet.add(seq);
    }
    ArrayList<String> ret = new ArrayList<String>();
    for (SubString substr : repeatSeqSet)
      ret.add(substr.toString());
    return ret;
  }
}

class SubString
{
  String str;
  int start;
  int end;

  public SubString (String str, int start, int end)
  {
    this.str = str;
    this.start = start;
    this.end = end;
  }

  public int length ()
  {
    return end - start;
  }

  public char charAt (int idx)
  {
    return str.charAt(start + idx);
  }

  @Override
  public int hashCode ()
  {
    int code = 0;
    for (int i = 0; i < this.length(); ++i)
    {
      code = code * 31 + (int)this.charAt(i);
    }
    return code;
  }

  @Override
  public boolean equals (Object obj)
  {
    if (!(obj instanceof SubString))
      return false;
    SubString other = (SubString)obj;
    if (this.length() != other.length())
      return false;
    for (int i = 0; i < this.length(); ++i)
    {
      if (this.charAt(i) != other.charAt(i))
        return false;
    }
    return true;
  }

  @Override
  public String toString ()
  {
    return str.substring(start, end);
  }
}
