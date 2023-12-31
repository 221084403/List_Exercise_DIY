/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.bl;

import java.util.List;

/**
 *
 * @author MNCEDISI
 * @param <T>
 */
public interface StudentInterface<T>
{
    public boolean addStudent(T student);
    
    public List<T> displayAllStudent();
    
    public boolean removeStudent(Long studentNum);
    
    public T searchStudent(Long studentNum);
    
    public boolean updateStudent(T student);
    
    public boolean storeToTextFile(List<T> list);
}
