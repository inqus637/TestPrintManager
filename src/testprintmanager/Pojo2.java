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
public class Pojo2{
    private final StringProperty pc11;
   
    //private final StringProperty pc15;

    public Pojo2(String pc11, String pc12, String pc13, String pc14) {
        this.pc11 = new SimpleStringProperty (pc11);
        
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

   
}

