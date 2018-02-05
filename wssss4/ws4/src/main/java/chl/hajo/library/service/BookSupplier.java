/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chl.hajo.library.service;

import chl.hajo.library.core.Book;
import chl.hajo.library.core.Genre;
import java.util.ArrayList;
import java.util.List;
//import java.util.Random;

/**
 *
 * @author macbook
 */
public class BookSupplier {
    
     public static List<Book> getBooks() {
        List<Book> books = new ArrayList<>();
        String[] bookies = {
            "AA123;Twilight;14.9",
            "AA456;MazeRunner;20.5",
            "AA789;TheLifeofParis;11.2",
            "BB012;ShadowHunters;18.3"
            };
        for (String s : bookies) {
            String[] d = s.split(";");
            Book a = new Book(d[0], d[1], (Double.parseDouble(d[2])));
            a.setGenre(Genre.randomLetter());
            books.add(a);
        }
        return books;
    }
     
     public static Genre getRandomGenre() {
         return Genre.randomLetter();
     }
}
