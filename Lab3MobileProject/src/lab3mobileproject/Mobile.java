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
public class Mobile {
    
    //member variables
    public String mobileOwnerName="";
    public String mobileNumber="";
    public float mobileBalance=0.0f;
    public String mobileOSName="";
    public boolean lock;
    
    //constructors
    public Mobile(){}
    public Mobile(String Name,String number,float balance,String OSName,boolean l)
    {
        
        this.mobileOwnerName=Name;
        this.mobileNumber=number;
        this.mobileBalance=balance;
        this.mobileOSName=OSName;
        this.lock=l;     
    }
    
    public void showinfo()
    {
        if(lock==false)
        {
        System.out.println("Name :"+mobileOwnerName);
        System.out.println("Number :"+mobileNumber);
        System.out.println("Balance :"+mobileBalance);
        System.out.println(" OS Name :"+mobileOSName);    
        }else 
        {
          System.out.println("Sorry!Your Phone is Locked");   
        }
        
    }
    
    public void recharge(int amount)
    {
        if(lock==false)
        {
             mobileBalance=mobileBalance+amount;  
             System.out.println("Balance after recharge :"+mobileBalance);
        }else
        {
               System.out.println("Sorry!Your Phone is Locked");
        }
     
    }
    
    public void callSomeone(int timeDuration)
    {
        if(lock==false)
        {
          for(int i=0;i<timeDuration;i++)
       {
           mobileBalance=mobileBalance-1;
       }  
          System.out.println("Remaining Balance :"+mobileBalance);
        }else
        {
            System.out.println("Sorry!Phone is Locked");
        }
       
    }
   
}
