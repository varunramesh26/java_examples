public class CliArg {

  // Employee details declared in arrays.
  int[] emp_no = {1001, 1002, 1003, 1004, 1005, 1006, 1007};
  String[] emp_name = {"Ashish", "Sushma", "Rahul", "Chahat", "Ranjan", "Suman", "Tanmay"};
  String[] join_date = {"01/04/2009", "23/08/2012", "12/11/2008", "29/01/2013", "16/07/2005", "01/01/2000", "12/06/2006"};
  char[] designation_code = {'e', 'c', 'k', 'r', 'm', 'e', 'c'};
  String[] department = {"R&D", "PM", "Acct", "Front Desk", "Engg", "Manufacturing", "PM"};
  int[] basic = {20000, 30000, 10000, 12000, 50000, 23000, 29000};
  int[] hra = {8000, 12000, 8000, 6000, 20000, 9000, 12000};
  int[] it = {3000, 9000, 1000, 2000, 20000, 4400, 10000};

  // Dearness Allowance(DA) related arrays.
  String[] designation = {"Engineer", "Consultant", "Clerk", "Receptionist", "Manager"};
  int[] da = {20000, 32000, 12000, 15000, 40000};

  void find_emp(int arg_value) {
    found:
    {
      for (int element : emp_no) {
        if (arg_value == element) {
          System.out.println("Emp id: " + arg_value);
          display_emp_details();
          break found;
        }
      }
      System.out.println("Emp id " + arg_value + " not found.");
    }
  }

  void display_emp_details(){
    System.out.println("Employee Details:\n");
    System.out.println("\nEmp No.  Emp Name      Department     Designation     Basic");
    System.out.println("------------------------------------------------------------");
    System.out.println(emp_no[0] +"     "+ emp_name[0] +"        "+ department[0] +"            "+ designation[0] +"       "+ basic[0]);
  }

  public static void main(String[] args) {
    /* Integer arg_value = Integer.valueOf(args[0]); */
    int arg_value = Integer.parseInt(args[0]);
    CliArg emp = new CliArg();
    emp.find_emp(arg_value);
  }
}
