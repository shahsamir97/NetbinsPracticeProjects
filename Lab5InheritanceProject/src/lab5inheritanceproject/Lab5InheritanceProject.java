
package lab5inheritanceproject;

public class Lab5InheritanceProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        grandParent gp = new grandParent("Mr GrandParent");
        
        
        Parent p1 = new Parent("MR father");
        Boy c1= new Boy("Mr Child");
        Girl g = new Girl("Mr Girl");
        gp.printInfo();
        p1.printInfo();
        c1.printInfo();
        g.printInfo();
    }
    
}
