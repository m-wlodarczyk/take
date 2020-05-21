/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.backing;

import java.util.Random;

/**
 *
 * @author mwlodarczyk
 */
public class StudentGenerator {
    public String[] names = {
        "JAN", "PIOTR", "STANISŁAW", "ANDRZEJ", "JÓZEF", "PAWEŁ", "KRZYSZTOF", 
        "ADAM", "TOMASZ", "MAREK", "ANNA", "MARIA", "KATARZYNA", "MAŁGORZATA", 
        "AGNIESZKA", "BARBARA", "EWA", "KRYSTYNA", "ELŻBIETA", "MAGDALENA"};
    public String[] surnames = {"NOWAK", "WÓJCIK", "KOWALCZYK", "WOŹNIAK", 
        "MAZUR", "KRAWCZYK", "KACZMAREK", "PAWLAK", "DUDEK", "STĘPIEŃ", 
        "ADAMCZYK", "KRÓL", "ZAJĄC", "WRÓBEL", "PIETRZAK", "BARAN", 
        "MICHALAK", "DUDA", "BĄK", "WALCZAK"};
    
    public StudentGenerator() { }
    
    public Student createRandomStudent() {
        Random r = new Random();
        return new Student(
                names[r.nextInt(19)], 
                surnames[r.nextInt(19)], 
                (float) 2 + r.nextFloat() * (5 - 2)
        );
    }
    
}
