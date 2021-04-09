package com.example.springinitializr.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Random;

@RestController
public class HelloWorldController {

    @RequestMapping("/")
    public String index(){
        return "Hello World";
    }

    @RequestMapping("/hej")
    public String index2(){
        return "Hello World igen";
    }

    @RequestMapping("/hello")
    public String hej (@RequestParam String namn){
        return "Hello " + namn;
    }

    //Övningsuppgift 1b, Lucky you
    @RequestMapping("/lucky-you")
    public String luckyYou (@RequestParam(required = false) String luckyYou){
        String result ="";
        Random random = new Random();
        if (luckyYou.equals("number")){

            int n = random.nextInt(9);
            result = String.valueOf(n);
        }
        if (luckyYou.equals("animal")){
            String[] animals = {"hund", "katt", "spindel", "skata", "hare"};
            int n = random.nextInt(animals.length);
            result = animals[n];
        }
        return result;
    }

    //Övningsuppgift 1c, Lucky you with optionals
    @RequestMapping("/lucky-you-optional")
    public String luckyYou2 (@RequestParam(required = false) String firstName, @RequestParam(required = false) String lastName){
        String result ="";
        String[] animals = {"hund", "katt", "spindel", "skata", "hare"};
        Random random = new Random();
        if (firstName != null && lastName != null){
            int n = random.nextInt(animals.length);
            result = firstName +" "+lastName +", ditt lyckodjur är " + animals[n];
        }
        if (firstName != null && lastName == null){
            int n = random.nextInt(animals.length);
            result = firstName +", ditt lyckodjur är " + animals[n];
        }
        if (lastName != null && firstName == null){
            int n = random.nextInt(animals.length);
            result = lastName +", ditt lyckodjur är " + animals[n];
        }
        if (firstName == null && lastName == null){
            int n = random.nextInt(animals.length);
            result = "Du har inte angett något namn!";
        }
        return result;
    }

    //Övningsuppgifter 1d
    @RequestMapping("/lucky-you-default")
    public String luckyYou3 (@RequestParam(defaultValue = "Micika") String firstName, @RequestParam(defaultValue = "Dostojevski") String lastName){
        String result ="";
        String[] animals = {"hund", "katt", "spindel", "skata", "hare"};
        Random random = new Random();
        if (firstName != null && lastName != null){
            int n = random.nextInt(animals.length);
            result = firstName +" "+lastName +", ditt lyckodjur är " + animals[n];
        }
        if (firstName != null && lastName == null){
            int n = random.nextInt(animals.length);
            result = firstName +", ditt lyckodjur är " + animals[n];
        }
        if (lastName != null && firstName == null){
            int n = random.nextInt(animals.length);
            result = lastName +", ditt lyckodjur är " + animals[n];
        }
        return result;
    }

    @RequestMapping("/hej3")
    public String hej3 (@RequestParam List<String> names){
        return "Hello " + names;
    }

    @RequestMapping("/hejPathParam/{name}")
    public String hej4 (@PathVariable String name){
        return "Hello " + name;
    }

    @RequestMapping("/hejHtml")
    public String hejHtml (@RequestParam List<String> names){
        return "<html><head></head><body>hej på er</body></html>" + names;
    }



}
