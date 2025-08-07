/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.librarysystem;

import com.sun.source.tree.NewArrayTree;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class LibrarySystem {

    public static void main(String[] args) {
       try{
           runner();
       } catch(InvalidOptionException ex) {
           System.out.println(ex.getMessage());
       }
    }
    
    public static void runner()throws InvalidOptionException{
        Scanner sc = new Scanner(System.in);
        ArrayList<Book> books = new ArrayList<>();
        
        int bookCount = 0;
        int libraryCapacity = 3;
        
        Library library = new Library(books);
        System.out.println("Welcome to the Library System!");
        
        while(true){
            System.out.print("""
                               What would you like to do?
                               A -> Add a book
                               B -> Remove a book
                               C -> View available books
                               X -> Exit
                               Response: """);
            char response = sc.next().charAt(0);
            System.out.println("");
            sc.nextLine();
            
            switch (response) {
                case 'A', 'a':
                    if(bookCount >= libraryCapacity){
                    System.out.println("The Library is at it's maxumum capacity "
                            + "and cannot accept more books. \n");
                    break;
                }else {
                    System.out.println("You're in luck,the Library can accept more books!");
                
                    System.out.print("Enter book title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter book author: ");
                    String author = sc.nextLine();

                    library.addBook(new Book(title, author));
                    bookCount = books.size();
//                    library.getBooks();
                    }
                    break;
                case 'B', 'b':
                    System.out.println("Enter the title of the book you wish to remove: ");
                    String bookName = sc.nextLine();
                    try {
                        library.removeBook(bookName);
                    } catch (Exception ex) {
                           System.out.println(ex.getMessage());
                           System.out.println("");
                    }
                    break;
                case 'C', 'c':
                    try{
                        library.getBooks();
                    }catch(Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case 'X', 'x':
                    System.exit(0);
                default:
                    throw new InvalidOptionException("You're gonna break it! \nTry again");
            }
        }
    }
}
