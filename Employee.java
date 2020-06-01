import java.lang.reflect.Array;
import java.lang.ArrayIndexOutOfBoundsException;

public class Employee {

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

  // Other class level variables.
  int salary = 0;
  int emp_salary = 0;

  // A function to find the employee with the Emp id (argument) passed in the command line.
  void find_emp(int arg_value) {
    found:
    {
      for (int element : emp_no) {
        if (arg_value == element) {
          // System.out.println("Emp id: " + arg_value);
          employee_match(arg_value);
          break found;
        }
      }
      System.out.println("There is no employee with Emp no. " + arg_value + ".\n");
    }
  }

  // A function with a switch case to match the employee details.
  public void employee_match(int arg_value){
    switch (arg_value){
      case 1001:
        emp_salary = calculate_salary(basic[0], hra[0], da[0], it[0]);
        display_message(arg_value, emp_salary, designation[0]);
        break;

      case 1002:
        emp_salary = calculate_salary(basic[1], hra[1], da[1], it[1]);
        display_message(arg_value, emp_salary, designation[1]);
        break;

      case 1003:
        emp_salary = calculate_salary(basic[2], hra[2], da[2], it[2]);
        display_message(arg_value, emp_salary, designation[2]);
        break;

      case 1004:
        emp_salary = calculate_salary(basic[3], hra[3], da[3], it[3]);
        display_message(arg_value, emp_salary, designation[3]);
        break;

      case 1005:
        emp_salary = calculate_salary(basic[4], hra[4], da[4], it[4]);
        display_message(arg_value, emp_salary, designation[4]);
        break;

      case 1006:
        emp_salary = calculate_salary(basic[5], hra[5], da[0], it[5]);
        display_message(arg_value, emp_salary, designation[0]);
        break;

      case 1007:
        emp_salary = calculate_salary(basic[6], hra[6], da[1], it[6]);
        display_message(arg_value, emp_salary, designation[1]);
        break;
    }
    // return arg_value;
  }

  // A method to calculate salary.
  int calculate_salary(int e_basic, int e_hra, int e_da, int e_it){
    salary = e_basic + e_hra + e_da - e_it;
    return salary;
  }

  // Display function for the employee details.
  void display_message(int emp_id, int emp_salary, String emp_desig) {
    System.out.println("\t\t\t\t\tEmployee Details");
    System.out.println("---------------------------------------------------------------------------------------------------");
    System.out.println("Emp No.\t\tEmp Name\t\tDepartment\t\tDesignation\t\tSalary");
    System.out.println("---------------------------------------------------------------------------------------------------");
    for (int i = 0; i < emp_no.length; i++) {
      if (emp_id == emp_no[i])
        System.out.println(emp_no[i] + "\t\t" + emp_name[i] + "\t\t\t" + department[i] + "\t\t\t" + emp_desig + "\t\t\t" + emp_salary +"\n");
    }
  /*
    // Alternate Display template.
    System.out.println("\tEMPLOYEE DETAILS");
    System.out.println("---------------------------------");
    for (int i = 0; i < emp_no.length; i++) {
      if (emp_id == emp_no[i]) {
        System.out.println("Emp No.:\t" + emp_no[i]);
        System.out.println("Emp Name:\t" + emp_name[i]);
        System.out.println("Department:\t" + department[i]);
        System.out.println("Designation:\t" + emp_desig);
        System.out.println("Salary:\t\t" + emp_salary);
      }
    }
    System.out.println("---------------------------------" +\n);
*/
  }

  // Main class.
  public static void main(String[] args) {
    Employee emp = new Employee();

    try {
      /* Integer arg_value = Integer.valueOf(args[0]); */
      int arg_value = Integer.parseInt(args[0]);
      emp.find_emp(arg_value);
    }
    catch (ArrayIndexOutOfBoundsException e) {
      System.out.println("Exception thrown : " + e);
      System.out.println("Please run the program again with Emp no.s from 1001-1007, from the command line.");
      System.out.println("\tFor ex: java Employee 1002");
    }
  }

}

