/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.backing;

/**
 *
 * @author mwlodarczyk
 */
public class Student {

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * @return the mean
     */
    public float getMean() {
        return mean;
    }
    private final String name;
    private final String surname;
    private float mean;
    
    public Student(String name, String surname, float mean) {
        this.name = name;
        this.surname = surname;
        this.mean = mean;
    }

    /**
     * @param mean the mean to set
     */
    public void setMean(float mean) {
        this.mean = mean;
    }
    
}
