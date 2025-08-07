/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.librarysystem;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Library {
    private ArrayList<Book> books;

    public Library(ArrayList<Book> books) {
        this.books = books;
    }
    
    public void addBook(Book book){
        books.add(book);
        System.out.println(book + " has been added\n");
    }
            
    public void removeBook(String bookTitle) throws Exception {
        boolean isFound = false;
        for(Book book: books){
            if(book.getTitle().equalsIgnoreCase(bookTitle)){
                isFound = true;
                books.remove(book);
                System.out.println(book.getTitle() + " has been removed.");
            }
        }
        if(!isFound){
            throw new Exception("Oops! " + bookTitle + " does not exist in the Library.");
        }
    }
    
    public void getBooks() throws Exception{
        System.out.println("AVAILABLE BOOKS: ");
        if(!books.isEmpty()){
            for(Book book: books){
                System.out.println(book);
            }
        } else {
            throw new Exception("--There are no books in the Library.--");
        }
        System.out.println(" ");
    }
}
