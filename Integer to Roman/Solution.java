public class Solution
{

  static final char[] ROMAN_LETTER = new char[]{'I', 'V', 'X', 'L', 'C', 'D', 'M', '?', '?'};

  static final String[] ROMAN_NUMBER = new String[]{"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

  String romanDigit (int digit, char one, char five, char ten)
  {
    String pattern = ROMAN_NUMBER[digit - 1];
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < pattern.length(); ++i)
    {
      char c = pattern.charAt(i);
      if (c == 'I')
        sb.append(one);
      else if (c == 'V')
        sb.append(five);
      else // if (c == 'X')
        sb.append(ten);
    }
    return sb.toString();
  }

  public String intToRoman (int num)
  {
    StringBuilder sb = new StringBuilder();
    int unit = 1000;
    int letterIdx = 6;
    while (unit > 0)
    {
      int digit = num / unit;
      if (digit > 0)
        sb.append(romanDigit(digit, ROMAN_LETTER[letterIdx], ROMAN_LETTER[letterIdx + 1], ROMAN_LETTER[letterIdx + 2]));
      num %= unit;
      unit /= 10;
      letterIdx -= 2;
    }
    return sb.toString();
  }

}
