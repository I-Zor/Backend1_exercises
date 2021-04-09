package com.example.springinitializr.repos;

import com.example.springinitializr.models.Book;
import com.example.springinitializr.models.Kompis;

import java.util.*;
import java.util.stream.Collectors;

public class DAO {

    public List<Book> getAllBooks (){
        Book b1 = new Book(1, "t1", "a1");
        Book b2 = new Book(2, "t2", "a2");
        Book b3 = new Book(3, "t3", "a3");
        Book b4 = new Book(4, "t4", "a4");
        Book b5 = new Book(5, "t5", "a5");
        Book b6 = new Book(6, "t6", "a6");

        List<Book> books = new ArrayList<>();
        books.add(b1);
        books.add(b2);
        books.add(b3);
        books.add(b4);
        books.add(b5);
        books.add(b6);
        return books;
    }
    List<Kompis> friends = new ArrayList<>();

    public List<Kompis> getAllFriends(){
        Kompis k1 = new Kompis(1, "n1", "1a", "t1");
        Kompis k2 = new Kompis(2, "n2", "a2", "t2");
        Kompis k3 = new Kompis(3, "n3", "a3", "t3");
        Kompis k4 = new Kompis(4, "n4", "a4", "t4");
        Kompis k5 = new Kompis(5, "n5", "a5", "t5");

        friends.add(k1); friends.add(k2); friends.add(k3); friends.add(k4); friends.add(k5);
        return friends;
    }

    public Kompis getFriend (String input){
        return friends.stream().filter(k->k.getName().equals(input)).findFirst().get();
    }
    List<String> namesAndPhones = new ArrayList<>();
    public List<String> getNamesAndPhones (){
        namesAndPhones = friends.stream().map(e->e.getName()+" "+e.getTelefon()).collect(Collectors.toList());
        return namesAndPhones;
    }
}
