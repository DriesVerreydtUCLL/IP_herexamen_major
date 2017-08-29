/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;

/**
 *
 * @author Dries
 */

public class Dummy implements Serializable {
    private String name;
    private int number;
    
    public Dummy(){
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
    
    public Dummy(String name, int number){
        this.name = name;
        this.number = number;
    }
    
    @Override
    public String toString(){
        return name + " " + number;
    }
}
