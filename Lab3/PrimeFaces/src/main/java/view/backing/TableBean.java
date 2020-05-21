/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.backing;

import view.backing.Student;
import view.backing.StudentGenerator;

import java.util.ArrayList;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author mwlodarczyk
 */
@Named(value = "tableBean")
@RequestScoped
public class TableBean {
    private ArrayList<Student> students;
    /**
     * Creates a new instance of TableBean
     */
    public TableBean() {
        students = new ArrayList<>();
        StudentGenerator gen = new StudentGenerator();
        for (int i=0; i<20; i++) {
            students.add(gen.createRandomStudent());
        }
    }

    /**
     * @return the students
     */
    public ArrayList<Student> getStudents() {
        return students;
    }
    
}
