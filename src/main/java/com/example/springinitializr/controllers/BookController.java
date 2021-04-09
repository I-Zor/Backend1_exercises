package com.example.springinitializr.controllers;

import com.example.springinitializr.models.Book;
import com.example.springinitializr.models.Message;
import com.example.springinitializr.repos.DAO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    DAO db = new DAO();
    List<Book> myBooks = db.getAllBooks();

    // Får JSON
    @RequestMapping("/books")
    public List<Book> books(){
        return myBooks;
    }

    @RequestMapping("/book/{id}")
    public Book bookById(@PathVariable int id){
        for(Book b: myBooks){
            if(b.getId()==id){
                return b;
            }
        }
        return null;

    }

    @RequestMapping("/book/{id}/delete")
    public List<Book> deleteBookById(@PathVariable int id){
        int bookToDelete = -1;
        for (int i = 0; i < myBooks.size(); i++){
            if(myBooks.get(i).getId() == id){
                bookToDelete = i;
            }
        }
        myBooks.remove(bookToDelete);
        return myBooks;

    }

    @PostMapping("/book/add")
    public String addBook(@RequestBody Book b){
        myBooks.add(b);
        return "book added";
    }

    @PostMapping("/book/upsert")
    public Message upsertBook(@RequestBody Book b){
        int bookToUpdate = -1;
        for (int i = 0; i < myBooks.size(); i++){
            if(myBooks.get(i).getId() == b.getId()){
                bookToUpdate = i;
            }
        }
        if(bookToUpdate == -1){
            myBooks.add(b);
            Message m = new Message(true, "Book was created");
            return m;
        }
        else{
            myBooks.set(bookToUpdate, b);
            Message m = new Message(true, "Book was updated");
            return m;
        }
    }



}
