
package lab5inheritanceproject;

public class grandParent {
//Properties
    protected String sing;
    protected String whoami="";
    protected String name="";
    protected double salary =100000;
    //constructor
    public grandParent()
    {
        this.whoami="Grand parent";
    }
    public grandParent(String n)
    {
        this.whoami="Grand Parent";
        this.name=n;
        this.sing="Folk";
        this.salary=1000;
    }
    
    public void printInfo()
    {
        System.out.println("I am a "+this.whoami);
        System.out.println("My name "+this.name);
        System.out.println("Salary :"+this.salary);
        System.out.println("Singer :"+this.sing+"\n");
    }
}
