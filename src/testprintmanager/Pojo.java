/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testprintmanager;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Администратор
 */
public class Pojo{
    private final StringProperty pc11;
    private final StringProperty pc12;
    private final StringProperty pc13;
    private final StringProperty pc14;
    private final StringProperty pc15;

    public Pojo(String pc11, String pc12, String pc13, String pc14,String pc15) {
        this.pc11 = new SimpleStringProperty (pc11);
        this.pc12 = new SimpleStringProperty (pc12);
        this.pc13 = new SimpleStringProperty (pc13);
        this.pc14= new SimpleStringProperty (pc14);
        this.pc15= new SimpleStringProperty (pc15);
        
   }


    

    public String getpc11() {
        return pc11.get();
    }

    public void setpc11(String pc11) {
        this.pc11.set(pc11);
    }

    public StringProperty Propertypc11() {
        return pc11;
    }

   public String getpc12() {
        return pc12.get();
    }

    public void setpc12(String pc12) {
        this.pc12.set(pc12);
    }

    public StringProperty Propertypc12() {
        return pc12;
    }

    public String getpc13() {
        return pc13.get();
    }

    public void setpc13(String pc13) {
        this.pc13.set(pc13);
    }

    public StringProperty Propertypc13() {
        return pc13;
    }   
    
    public String getpc14() {
        return pc14.get();
    }

    public void setpc14(String pc14) {
        this.pc14.set(pc14);
    }

    public StringProperty Propertypc14() {
        return pc14;
    }

   public String getpc15() {
        return pc15.get();
    }

    public void setpc15(String pc15) {
        this.pc15.set(pc15);
    }

    public StringProperty Propertypc15() {
        return pc15;
    }
    
}

