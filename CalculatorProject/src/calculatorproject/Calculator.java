
package calculatorproject;

public class Calculator {

    float a=0.0f;
    float b=0.0f;
    
    public Calculator()
    {
        System.out.println("Calculator Running ");
    }
    
    public float add(float x,float y)
    {
        return x+y;
    }
    
    public float sub(float x,float y)
    {
        return x-y; 
    }
    
    public float mul(float x,float y)
    {
        return x*y;
    }
    
    public float div(float x,float y)
    {
        if(y!=0.0f)
            return x/y;
        else
            System.out.println("cannot be divided");
        return 0;
    }
    
    public static void main(String[] args) {
       
        Calculator c =new Calculator();
        System.out.println("+ Result "+c.add(10.0f, 5.0f));
        System.out.println("- Result "+c.sub(10.0f, 5.0f));
        System.out.println("* Result "+c.mul(10.0f, 5.0f));
        System.out.println("/ Result "+c.div(10.0f, 5.0f));
                

                
    }
    
}
