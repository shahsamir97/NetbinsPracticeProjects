
package lab3libraryproject;
public class Book {
 private String bookName="";
 private String bookAuthor="";
 private String BookId="";
 private String BookType="";
 public int bookCopy=0;
 
 //constrctor
 public Book(){}
 
 public Book(String name,String author,String id,String type,int copy)
 {
     this.bookName=name;
     this.bookAuthor=author;
     this.BookId=id;
     this.BookType=type;
     this.bookCopy=copy;
     System.out.println("Book Created");
  
 }
 
 
 
 public void showifo()
{
    System.out.println("Book Details");
System.out.println("Book Name :"+bookName);
System.out.println("Book Author :"+bookAuthor);
System.out.println("Book ID :"+BookId);
System.out.println("Book Type :"+BookType);
System.out.println("Book Copies :"+bookCopy);
}
 
 

 public void addCopy(int x)
 {
     this.bookCopy+=x;
 }
    
         
}