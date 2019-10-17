/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3mobileproject;

/**
 *
 * @author Samir
 */
public class MainClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Mobile m1= new Mobile("Samir","01626737227",50.0f,"Android",false);
        m1.showinfo();
        m1.recharge(50);
        m1.callSomeone(10);
        
        
        Mobile m2= new Mobile("Micle","0912289",40.0f,"iOS",true);
        m2.showinfo();
        m2.recharge(50);
        m2.callSomeone(20);
        
    }
    
}
