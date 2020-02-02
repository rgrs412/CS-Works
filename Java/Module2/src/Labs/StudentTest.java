package Labs;

/**
 * This program creates an array of Student objects and prints the state of each object in the array.
 * The Student class has already been created for you. Do not modify the Student class in any way.
 *
 * Prompt the user to enter the number of students they wish to store in the array.
 *
 * Create an array of Student objects using that input as the length.
 *
 * Prompt the user to enter the name and GPA for each student.
 *   Create a Student object and supply it with the two inputs.
 *   Store the Student object at the next available index in the array.
 *   Do this for each student.
 *
 * Print each student's name and GPA, using the Student objects you stored in the array.
 *
 * SAMPLE INPUT/OUTPUT
 *
 * Enter the number of students: 2
 *
 * Enter the student's name: John Smith
 * Enter the John Smith's GPA: 3.5
 * Enter the student's name: Jane Smith
 * Enter the Jane Smith's GPA: 3.9
 *
 * Student 1: John Smith 3.5
 * Student 2: Jane Smith 3.9
 *
 * (You only need to post this source code file in the Module 2 Lab Discussion, if this is the lab you chose to complete)
 */
import java.util.Scanner;
import Labs.Student;
public class StudentTest {

    /**
     * Main Method. This is where the program begins.
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);                             //Instantiates a Scanner object
        int nStudent;                                                       //Number of students
        int i;                                                              //Loop counter
        String name;                                                        //Name of student
        double gpa;                                                         //GPA of student

        System.out.print("Enter the number of students: ");
        nStudent = Integer.parseInt(input.nextLine());
        System.out.println("");

        Student[] student = new Student[nStudent];
        for(i = 0; i < student.length; i++) {
            System.out.print("Enter student " + (i + 1) + "'s name: ");
            name = input.nextLine();
            System.out.print("Enter student " + (i + 1) + "'s GPA: ");
            gpa = Double.parseDouble(input.nextLine());

            student[i] = new Student(name, gpa);
        }

        System.out.println("");
        for(i = 0; i < student.length; i++) {
            System.out.println("Student " + (i + 1) + ": " + student[i].getName() + " " + student[i].getGPA());
        }
    }

}
