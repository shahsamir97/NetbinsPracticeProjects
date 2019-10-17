/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3libraryproject;

/**
 *
 * @author Samir
 */
public class Library {
    private String libName="";
    private String libAddress="";
    private int totalBook;
    
    private Book[] listOfBook= new Book[totalBook];
    
    public Library(){}
    public Library(String libName,String libAddress,Book listOfBook[])
    {
        this.libName=libName;
        this.libAddress=libAddress;
        this.listOfBook=listOfBook;
    }
    
    public void totalBooks(Book book[])
    {
        for(int i=0;i<book.length;i++)
        {
            totalBook=book[i].bookCopy+totalBook;
        }
    }
    
    public void addNewBook(Book book)
    {
        
    }

     public void LibInfo()
     {
         System.out.println("Library Name :"+libName);
         System.out.println("Library Address :"+libAddress);
         System.out.println("Library total Books :"+totalBook);
     }

   
    
    
    
}
