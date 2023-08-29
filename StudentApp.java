/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentapp;

import java.util.*;
import za.ac.tut.entities.*;
import za.ac.tut.studentmanager.StudentManager;

/**
 *
 * @author MNCEDISI
 */
public class StudentApp 
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
        
        StudentManager sm = new StudentManager();
        String statement = "";
        
        int option = displayOption();
        
        do 
        {       
            switch(option)
            {
                case 1:
                    Student student = createStudent();
                    
                    if(sm.addStudent(student))
                        System.out.println("The student is added");
                    else
                        System.err.println("The student is not added");
                    break;
                    
                case 2:
                    List<Student> list = sm.displayAllStudent();
                    
                    if(!list.isEmpty())
                        displayStudents(list);
                    else
                        System.err.println("No students in the list");  
                    break;
                    
                case 3:
                    statement = "Please Enter the student number of the student want to remove :";
                    Long studentNum = getStudentNum(statement);
                    
                    if(sm.removeStudent(studentNum))
                        System.out.println("The student is removed");
                    else
                        System.err.println("The student is not removed");
                    break;
                    
                case 4:
                    statement = "Please enter the student number of the student you need :";
                    studentNum = getStudentNum(statement);
                    
                    student = sm.searchStudent(studentNum);
                    
                    if(student!=null)
                        displayStudent(student);
                    else
                        System.err.println("No such student");
                    break;
                    
                case 5:
                    student = createStudent();
                    
                    if(sm.updateStudent(student))
                        System.out.println("The student is updatered");
                    else
                        System.err.println("The student is not updated");
                    break;
                    
                case 6:
                    list = sm.displayAllStudent();
                    
                    if(sm.storeToTextFile(list))
                        System.out.println("The information is stored in the file");
                    else
                        System.err.println("The information is not stored");
                    break;
                    
                default:
                    System.err.println("Invalid option. Please re-enter\n");
                    break;
                    
            }
            
            option  = displayOption();
            
        } while (option!=7);
    }

    private static int displayOption() 
    {
        Scanner sc = new Scanner(System.in);
        
        String menu = "\nPlease select one of the following option:\n\n"+
                      "1. Add a student in the classlist.\n"+
                      "2. Display the details of all the students in the classlist.\n"+
                      "3. Remove a student from the classlist.\n"+
                      "4. Search for a student.\n"+
                      "5. Update the details of a student.\n"+
                      "6. Store the contents of the list in a text file.\n"+
                      "7. Exit\n\n"+
                      "Your option :";
        
        System.out.print(menu);
        
        return sc.nextInt();
    }

    private static Student createStudent()
    {
        Scanner sc = new Scanner(System.in);
        List<Subject> theSubject = new ArrayList<>();
        
        System.out.println("Please enter the following details\n");
        
        System.out.print("Enter your student Number\t:");
        Long studentNum = sc.nextLong();
        
        sc.nextLine();
        
        System.out.print("Enter your name\t\t\t:");
        String name = sc.nextLine();
        
        System.out.print("Enter your surname\t\t:");
        String surname = sc.nextLine();
        
        System.out.print("How many subject did you do\t:");
        int numOfSubj = sc.nextInt();
        
        sc.nextLine();
        
        for (int i = 0; i < numOfSubj; i++) 
        {     
            System.out.print("\nSubject :"+(1 + i)+
                             "\nSubject Code\t:");
            String subjectCode = sc.nextLine();
            
            System.out.print("Subject Name\t:");
            String subjectName = sc.nextLine();
            
            theSubject.add(new Subject(subjectCode, subjectName));
        }
        
        Student student = new Student(studentNum, name, surname);
        student.setList(theSubject);
        
        return student;
    }

    private static void displayStudents(List<Student> list) 
    {
        String outcome = "";
        
        for (Student display : list) 
        {
            outcome+= "\nStudent No\t:"+display.getStudentNum()+"\n"+
                      "Name\t\t:"+display.getName()+"\n"+
                      "Surname\t\t:"+display.getSurname()+"\n"+
                       display.getList().toString()+"\n";  
        }
        
        System.out.println(outcome);
    }

    private static Long getStudentNum(String statement) 
    {
        Scanner sc = new Scanner(System.in);
        
        System.out.print(statement);
        return sc.nextLong();
    }

    private static void displayStudent(Student student)
    {
        String outcome="Student No\t:"+student.getStudentNum()+"\n"+
                       "Name\t\t:"+student.getName()+"\n"+
                       "Surname\t\t:"+student.getSurname()+"\n"+
                        student.getList().toString();
        
        System.out.println(outcome);
    }
}
