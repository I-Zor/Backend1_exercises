package com.example.springinitializr.controllers;

import com.example.springinitializr.models.Book;
import com.example.springinitializr.models.Kompis;
import com.example.springinitializr.models.Message;
import com.example.springinitializr.repos.DAO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class KompisController {

    DAO db = new DAO();
    List<Kompis> myFriends = db.getAllFriends();

    // Får JSON
    @RequestMapping("/kompis")
    public List<Kompis> friends(){
        return myFriends;
    }

    @RequestMapping("/one-kompis")
    public Kompis friend(@RequestParam(required = false) String name){
        Kompis k = db.getFriend(name);
        return k;
    }

    // Övning 3, kompis web service
    @RequestMapping("/kompis-service")
    public List<String> l(){
        List<String> list = db.getNamesAndPhones();
        return list;
    }

    // Övning 4
    @RequestMapping("/kompis-by-id/{id}")
    public Kompis friendById(@PathVariable int id){
        return myFriends.stream().filter(k->k.getId()==id).findFirst().get();

    }

    @PostMapping("/kompis/upsert")
    public Message upsertKompis(@RequestBody Kompis k){
        int kompisToUpdate = -1;
        for (int i = 0; i < myFriends.size(); i++){
            if(myFriends.get(i).getId() == k.getId()){
                kompisToUpdate = i;
            }
        }
        if(kompisToUpdate == -1){
            myFriends.add(k);
            Message m = new Message(true, "Friend was created");
            return m;
        }
        else{
            myFriends.set(kompisToUpdate, k);
            Message m = new Message(true, "Friend was updated");
            return m;
        }
    }



}
