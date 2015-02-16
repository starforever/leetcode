public class DivTest
{
  public static void main (String[] args)
  {
    int a = Integer.parseInt(args[0]);
    int b = Integer.parseInt(args[1]);
    System.out.format("%d / %d = %d%n", a, b, a / b);
    System.out.format("%d %% %d = %d%n", a, b, a % b);
  }
}
