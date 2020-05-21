/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.backing;

import java.util.Date;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author mwlodarczyk
 */
@Named(value = "sumBean")
@RequestScoped
public class SumBean {
    
    private int x;
    private int y;
    private Date date = new Date();
    
    public void showGrowlMsg() {
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage msg = 
                new FacesMessage(
                        String.format(
                                "%d + %d = %d", this.x, this.y, this.x + this.y
                        )
                );
        context.addMessage(null, msg);}

    /**
     * Creates a new instance of SumBean
     */
    public SumBean() {
    }

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }
    
}
