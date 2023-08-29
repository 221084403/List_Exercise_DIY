/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.entities;

/**
 *
 * @author MNCEDISI
 */
public class Subject 
{
    private String subjectCode;
    private String subjectName;

    public Subject(String subjectCode, String subjectName)
    {
        this.subjectCode = subjectCode;
        this.subjectName = subjectName;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Subject() {
    }

    @Override
    public String toString() 
    {
        return "\nSubject Code\t:"+getSubjectCode()+
               "\nSubject Name\t:"+getSubjectName();
    } 
}
