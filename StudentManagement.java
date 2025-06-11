package Projects;


//TOPIC -> Student management system
//          The program should :-
//             provide the following functionalities :-
//             A) ADD A STUDENT : Allow user to add a new student with a unique ID(or roll number),name,grade' .
//             B) REMOVE A STUDENT : Allow user to remove an existing student by specifying the student ID .
//             C) UPDATE STUDENT INFORMATION : Allow the user to update the information (name,age,grade) of an existing student by their specific id .
//             D) SEARCH FOR A STUDENT : Allow the user to search for a student by name or ID and display their details(ID,name,age,grade) .
//             E) DISPLAY ALL STUDENT : Display all students in the school with their details .

import java.util.*;

public class StudentManagement {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("************************************************************************");
        System.out.println("                             ADD A STUDENT                              ");
        System.out.println("************************************************************************");

        // => A) ADD A STUDENT : Allow user to add a new student with a unique ID(or roll number),name,grade'
        HashMap<String, HashMap<String, String>> dt = new HashMap<>();
        int n;

        while (true) {
            System.out.print("Enter total students you want to add : ");
            String nStr = sc.nextLine();
            if (nStr.matches("\\d+")) {
                n = Integer.parseInt(nStr);
                break;
            } else {
                System.out.println("_ _ _ _ _ _ _ _ _ _ _ ");
                System.out.println(" << INVALID NUMBER >> ");
                System.out.println("_ _ _ _ _ _ _ _ _ _ _ ");
            }
        }

        // code to get data of students from user
        for (int i = 1; i <= n; i++) {
            System.out.println("Enter details of student-" + i + " : ");
            String a;
            while (true) {
                System.out.print("Name -> ");
                a = sc.nextLine();
                if (a.length() < 20 && a.length() > 3)
                    break;
                else {
                    System.out.println("<< Name should be less than 20 character and more than 3 character >>");
                }
            }

            String b;
            while (true) {
                System.out.print("Age -> ");
                b = sc.nextLine();
                if (b.matches("\\d+"))
                    break;
                else {
                    System.out.println("<< INVALID NUMBER >>");
                }
            }

            String c;
            while (true) {
                System.out.print("Grade -> ");
                c = sc.nextLine();
                if (c.length() < 3)
                    break;
                else {
                    System.out.println("<< grade can not be more than 2 character >>");
                }
            }

            HashMap<String, String> student = new HashMap<>();
            student.put("name", a);
            student.put("age", b);
            student.put("grade", c);
            dt.put("st" + i, student);
        }

        // code to print the data of students provided by the user
        System.out.println("\nTHE DETAILS OF STUDENTS ARE :- ");
        System.out.println("=>Roll No.- Name - Age - Grade  <=");
        for (int i = 1; i <= n; i++) {
            HashMap<String, String> st = dt.get("st" + i);
            System.out.println(" " + i + ")" + st.get("name") + "-" + st.get("age") + "-" + st.get("grade"));
        }

        System.out.println("------------------------------------------------------------------------\n");
        System.out.println("************************************************************************");
        System.out.println("                           REMOVE A STUDENT                             ");
        System.out.println("************************************************************************");

        // => B) REMOVE A STUDENT : Allow user to remove an existing student by specifying the student ID
        int term;
        while (true) {
            System.out.print("Enter total students whose details you want to delete : ");
            String termStr = sc.nextLine();
            if (termStr.matches("\\d+")) {
                term = Integer.parseInt(termStr);
                if (term < n)
                    break;
                else
                    System.out.println("\"THE NUMBER YOU ENTERED IS MORE THAN THE TOTAL STUDENTS . ENTER A VALID NUMBER\"");
            } else {
                System.out.println("<< INVALID NUMBER >>");
            }
        }

        ArrayList<Integer> lst = new ArrayList<>();

        for (int i = 1; i <= term; i++) {
            int roll;
            while (true) {
                System.out.print("Enter the roll number : ");
                String rollStr = sc.nextLine();
                if (rollStr.matches("\\d+")) {
                    roll = Integer.parseInt(rollStr);
                    if (dt.containsKey("st" + roll))
                        break;
                    else
                        System.out.println("INVALID ROLL NUMBER");
                } else {
                    System.out.println("INVALID NUMBER");
                }
            }
            dt.remove("st" + roll);
            lst.add(roll);
        }

        // code to print the data of students after deleting some students data provided by the user
        System.out.println("\nTHE DETAILS OF STUDENTS AFTER MODIFICATION ARE :- ");
        for (int i = 1; i <= n; i++) {
            if (!lst.contains(i) && dt.containsKey("st" + i)) {
                HashMap<String, String> st = dt.get("st" + i);
                System.out.println(" " + i + ")  => " + st.get("name") + " => " + st.get("age") + " => " + st.get("grade"));
            }
        }

        System.out.println("------------------------------------------------------------------------\n");
        System.out.println("************************************************************************");
        System.out.println("                   UPDATE STUDENT INFORMATION                           ");
        System.out.println("************************************************************************");

        // => C) UPDATE STUDENT INFORMATION : update info by roll no.
        int tot;
        while (true) {
            System.out.print("Enter total student whose data you want to update : ");
            String totStr = sc.nextLine();
            if (totStr.matches("\\d+")) {
                tot = Integer.parseInt(totStr);
                if (tot <= (n - term))
                    break;
                else
                    System.out.println("\"THE NUMBER YOU ENTERED IS MORE THAN THE TOTAL STUDENTS . ENTER A VALID NUMBER\"");
            } else {
                System.out.println("<< INVALID NUMBER >>");
            }
        }

        for (int i = 0; i < tot; i++) {
            int roll_no;
            while (true) {
                System.out.print("Enter roll number : ");
                String rollStr = sc.nextLine();
                if (rollStr.matches("\\d+")) {
                    roll_no = Integer.parseInt(rollStr);
                    if (dt.containsKey("st" + roll_no))
                        break;
                    else
                        System.out.println("<< INVALID ROLL NUMBER >>");
                } else {
                    System.out.println("<< INVALID NUMBER >>");
                }
            }

            String fr;
            while (true) {
                System.out.print("Enter what you want to update (name,age,grade) : ");
                fr = sc.nextLine();
                if (fr.equals("name") || fr.equals("age") || fr.equals("grade"))
                    break;
                else
                    System.out.println("<< INVALID OPERATION >>");
            }

            System.out.print("Enter the new " + fr + " : ");
            String up = sc.nextLine();
            dt.get("st" + roll_no).put(fr, up);
        }

        // display after update
        System.out.println("\nTHE DETAILS OF STUDENTS AFTER UPDATION ARE :- ");
        System.out.println("=>Roll No.- Name - Age - Grade  <=");
        for (int i = 1; i <= n; i++) {
            if (!lst.contains(i) && dt.containsKey("st" + i)) {
                HashMap<String, String> st = dt.get("st" + i);
                System.out.println(" " + i + ")  => " + st.get("name") + " => " + st.get("age") + " => " + st.get("grade"));
            }
        }

        System.out.println("------------------------------------------------------------------------\n");
        System.out.println("************************************************************************");
        System.out.println("                        SEARCH FOR A STUDENT                            ");
        System.out.println("************************************************************************");

        // => D) SEARCH FOR A STUDENT : by roll no.
        int k;
        while (true) {
            System.out.print("Enter total students you want to search : ");
            String kStr = sc.nextLine();
            if (kStr.matches("\\d+")) {
                k = Integer.parseInt(kStr);
                if (k <= (n - term))
                    break;
                else
                    System.out.println("\"THE NUMBER YOU ENTERED IS MORE THAN THE TOTAL STUDENTS . ENTER A VALID NUMBER\"");
            } else {
                System.out.println("<< INVALID NUMBER >>");
            }
        }

        for (int i = 1; i <= k; i++) {
            System.out.println("STUDENT" + i + ":");
            String search;
            while (true) {
                System.out.print("Enter the roll number of the student you want to search : ");
                search = sc.nextLine();
                if (dt.containsKey("st" + search))
                    break;
                else
                    System.out.println("<< ENTER VALID ROLL NUMBER >>");
            }

            HashMap<String, String> st = dt.get("st" + search);
            System.out.println("Name => " + st.get("name"));
            System.out.println("Age => " + st.get("age"));
            System.out.println("Grade => " + st.get("grade"));
        }

        System.out.println("------------------------------------------------------------------------\n");
        System.out.println("************************************************************************");
        System.out.println("                         DISPLAY ALL STUDENT                            ");
        System.out.println("************************************************************************");

        // => E) DISPLAY ALL STUDENT
        System.out.println("TO DISPLAY ALL THE REMAINING STUDENTS DATA, ENTER '1' , if don't want press enter");
        String ch = sc.nextLine();

        if (ch.equals("1")) {
            System.out.println("\nTHE DETAILS OF ALL STUDENTS :- ");
            int h = 1;
            for (int i = 1; i <= n; i++) {
                if (!lst.contains(i) && dt.containsKey("st" + i)) {
                    HashMap<String, String> st = dt.get("st" + i);
                    System.out.println(h + ") Name => " + st.get("name"));
                    System.out.println("   Age => " + st.get("age"));
                    System.out.println("   Grade => " + st.get("grade"));
                    h++;
                }
            }
        }

        System.out.println("\n**************************************");
        System.out.println("THANK YOU \nPROGRAM RUNS SUCCESFULLY");
        System.out.println("**************************************");

        sc.close();
    }
}
