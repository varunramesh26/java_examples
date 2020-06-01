import java.util.*;

public class CliArg {


  // Employee details declared in arrays.
  int[] emp_no = {1001, 1002, 1003, 1004, 1005, 1006, 1007};
  String[] emp_name = {"Ashish", "Sushma", "Rahul", "Chahat", "Ranjan", "Suman", "Tanmay"};
  String[] join_date = {"01/04/2009", "23/08/2012", "12/11/2008", "29/01/2013", "16/07/2005", "01/01/2000", "12/06/2006"};
  String[] designation_code = {"e", "c", "k", "r", "m", "e", "c"};
  String[] department = {"R&D", "PM", "Acct", "Front Desk", "Engg", "Manufacturing", "PM"};
  int[] basic = {20000, 30000, 10000, 12000, 50000, 23000, 29000};
  int[] hra = {8000, 12000, 8000, 6000, 20000, 9000, 12000};
  int[] it = {3000, 9000, 1000, 2000, 20000, 4400, 10000};
  int salary = 0;
  int i = 0;

  // Dearness Allowance(DA) related arrays.
  String[] designation = {"Engineer", "Consultant", "Clerk", "Receptionist", "Manager"};
  int[] da = {20000, 32000, 12000, 15000, 40000};



  void find_emp(int arg_value, int emp_no_mapped) {
    found:
    {
      for (int element : emp_no) {
        if (arg_value == element) {
          System.out.println("Emp id: " + arg_value);
          for (int i=0; i < designation_code.length; i++) {
            if (arg_value == emp_no[i]) {
               String desig_code = designation_code[i];
               salary = calculate_salary(desig_code, emp_no_mapped);
             // salary = basic[i] + hra[i] + da[i] - it[i];
              System.out.println(emp_no[i] + "     " + emp_name[i] + "        " + designation[i] + "        " + salary);
            }
          }
          //display_emp_details(arg_value);
          break found;
        }
      }
      System.out.println("Emp id " + arg_value + " not found.");
    }
  }

  public int calculate_salary(String desig_code, int emp_no_mapped) {
    for (String element: emp_name){
      for (i=0; i < emp_no.length; i++){
        if (emp_no_mapped == emp_no[i])  {
            salary = basic[i] + hra[i] + da[i] - it[i];
        }

      }
    }
      return salary;
  }



  /* void display_emp_details(int arg_value) {
    System.out.println("Employee Details:\n");
    System.out.println("\nEmp No.  Emp Name      Department     Designation     Basic");
    System.out.println("------------------------------------------------------------");
    for (int i = 0; i < designation.length; i++) {

      System.out.println(emp_no[i] + "     " + emp_name[i] + "        " + department[i] + "            " + designation[i] + "       " + basic[i]);
    }
  }

   */



  public static void main(String[] args) {

    /* Integer arg_value = Integer.valueOf(args[0]); */
    int arg_value = Integer.parseInt(args[0]);
    CliArg emp = new CliArg();
    //String designation_mapped = "";

   // emp.find_emp(arg_value);
   // emp.calculate_salary(arg_value);

    HashMap<String, String> dc = new HashMap<String, String>();
    // Mapping designation_code and designation.
    dc.put(emp.designation_code[0], emp.designation[0]);
    dc.put(emp.designation_code[1], emp.designation[1]);
    dc.put(emp.designation_code[2], emp.designation[2]);
    dc.put(emp.designation_code[3], emp.designation[3]);
    dc.put(emp.designation_code[4], emp.designation[4]);

    HashMap<Integer, String> empd = new HashMap<Integer, String>();
    // Mapping emp_no and designation.
    empd.put(emp.emp_no[0], emp.designation[0]);
    empd.put(emp.emp_no[1], emp.designation[1]);
    empd.put(emp.emp_no[2], emp.designation[2]);
    empd.put(emp.emp_no[3], emp.designation[3]);
    empd.put(emp.emp_no[4], emp.designation[4]);
    empd.put(emp.emp_no[5], emp.designation[4]);
    empd.put(emp.emp_no[6], emp.designation[4]);

    HashMap<String, Integer> dda = new HashMap<String, Integer>();
    // Mapping designation and da(dearness allowance).
    dda.put(emp.designation[0], emp.da[0]);
    dda.put(emp.designation[1], emp.da[1]);
    dda.put(emp.designation[2], emp.da[2]);
    dda.put(emp.designation[3], emp.da[3]);
    dda.put(emp.designation[4], emp.da[4]);



   for (Map.Entry m: empd.entrySet()) {
      int emp_no_mapped = Integer.parseInt(String.valueOf(m.getKey()));
      found:
      {
        for (int element : emp.emp_no) {
          if (arg_value == element) {
            if (arg_value == emp_no_mapped){
                emp.find_emp(arg_value, emp_no_mapped);

            }

              //System.out.println(m.getKey() + " " + m.getValue());
            //System.out.println("Emp id: " + arg_value);

           /* for (int i=0; i < emp.designation_code.length; i++) {
              if (arg_value == emp.emp_no[i]) {

                String desig_code = emp.designation_code[i];

                //calculate_salary(desig_code);
                emp.salary = emp.basic[i] + emp.hra[i] + emp.da[i] - emp.it[i];
                System.out.println(emp.emp_no[i] + "     " + emp.emp_name[i] + "        " + desig_code + "        " + emp.salary);
              }
            } */
            //display_emp_details(arg_value);
           // break found;
          }
        }
       // System.out.println("Emp id " + arg_value + " not found.");
      }

      }

      //System.out.println(designation_mapped);
      //System.out.println(m.getKey() +" "+ m.getValue());
    }

   // emp.find_emp(arg_value, designation_mapped);

/*    for (Map.Entry m: mp.entrySet()){
      System.out.println(m.getKey() + " " + m.getValue());
    }  */
    //emp.find_emp(arg_value, mp);

  }


