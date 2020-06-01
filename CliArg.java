public class CliArg {
  public static void main(String[] args) {
    int[] emp_no = {1002, 1003};
    /* Integer arg_value = Integer.valueOf(args[0]); */
    int arg_value = Integer.parseInt(args[0]);

    found:
    {
      for (int element : emp_no) {
        if (arg_value == element) {
          System.out.println("Emp id: " + arg_value);
          break found;
        }
      }
      System.out.println("Emp id " + arg_value + " not found.");
    }

  }
}
