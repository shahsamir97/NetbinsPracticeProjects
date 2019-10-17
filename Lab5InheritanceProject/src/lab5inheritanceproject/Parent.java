/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5inheritanceproject;

/**
 *
 * @author Samir
 */
public class Parent extends grandParent {
    
    //properties
    
    
 
    //Constructor
    public Parent(){
    this.whoami=" Parent";}
    public Parent(String name)
    {
        this.whoami="Parent";
        this.name=name;
        this.salary=100000;
        this.sing="Solo";
    }
    //methods
    private void printSalary()
    {
        System.out.println("Salary :"+this.salary);
    }
    
}
