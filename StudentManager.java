/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.studentmanager;

import java.io.*;
import java.util.*;
import za.ac.tut.bl.*;
import za.ac.tut.entities.*;

/**
 *
 * @author MNCEDISI
 */
public class StudentManager implements StudentInterface<Student>
{
    private List<Student> list;
    
    public StudentManager()
    {
        list = new ArrayList<>();
    }
    
    @Override
    public boolean addStudent(Student student) 
    {
        if(list.add(student))
           return true;
        else
            return  false;
    }

    @Override
    public List<Student> displayAllStudent() 
    {
        return list;
    }

    @Override
    public boolean removeStudent(Long studentNum) 
    {
        boolean remove = false;
        
        for (Student display : list) 
        {
            if(display.getStudentNum().equals(studentNum))
            {
                int index = list.indexOf(display);
                list.remove(index);
              
                remove = true;
            }
        }
        
        return  remove;
    }

    @Override
    public Student searchStudent(Long studentNum) 
    {
        Student student = null;
        
        for (Student display : list)
        {
            if(display.getStudentNum().equals(studentNum))
                student = display;
        }
        
        return student;
    }

    @Override
    public boolean updateStudent(Student student) 
    {
        boolean update = false;
        
        for (Student display : list) 
        {
            if(display.getStudentNum().equals(student.getStudentNum()))
            {
                int index  = list.indexOf(display);
                list.set(index, student);
                
                update = true;
            }
        }
        
        return update;
    }

    @Override
    public boolean storeToTextFile(List<Student> list) 
    {
        String errorMsg = "" , outcome = "";
        boolean store = false;
            
        try
        {
            File file = new File("E:\\Advanced Object-Oriented Programming\\Data Structure\\Exercise DIY\\List\\Student.txt");
           
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);

            for (Student display : list) 
            {
                Long studentNum = display.getStudentNum();
                String name = display.getName();
                String surname = display.getSurname();

                String subject = display.getList().toString();

                outcome=studentNum+","+name+","+surname+","+subject;
                
                bw.write(outcome);
                
                bw.newLine();
            }

            bw.close();

            store = true;
        } 

        catch (IOException ex) 
        {
            errorMsg="Something went wrong\n"+ex.getMessage();
            System.err.println(errorMsg);
        }
       
        return store;
    }   
}
