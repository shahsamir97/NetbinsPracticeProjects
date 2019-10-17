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
public class Lab3LibraryProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
      Book [] book= new Book[3];
      
      book[0]= new Book("Java Programming","James Gosling","1111","Programming",10);
      book[0].showifo();
      book[0].addCopy(5);
      //book[0].returnBookCopies();
      
      book[1]= new Book("C++ Programming","Karmel","2222","Programming",15);
      book[1].showifo();
      book[1].addCopy(10);
      //book[1].returnBookCopies();
      
      book[2]= new Book("C# Tutorials","Smith","3333","Programming",5);
      book[2].showifo();
      book[2].addCopy(9);
      //book[2].returnBookCopies();
      
      Library L1= new Library("Tech Library","18th Ave",book);
      L1.totalBooks(book);
      L1.LibInfo();
    }
    
}
