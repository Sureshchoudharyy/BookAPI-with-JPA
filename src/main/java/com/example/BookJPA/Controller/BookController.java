package com.example.BookJPA.Controller;

import com.example.BookJPA.Entity.Book;
import com.example.BookJPA.Repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookRepo bookRepo;

    @PostMapping
    public Book addBook(@RequestBody Book book){
        return bookRepo.save(book);
    }

    @GetMapping
    public List<Book> getAllBooks(){
        return bookRepo.findAll();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id){
        return bookRepo.findById(id).orElseThrow(()->new RuntimeException("Book not found!"));
    }

    @PutMapping
    public Book updateBook(@RequestParam Long id, @RequestBody Book book){
        Book b = bookRepo.findById(id).orElseThrow(()->new RuntimeException("Book not found!"));
        b.setAuthor(book.getAuthor());
        b.setTitle(book.getTitle());
        b.setPublishedYear(book.getPublishedYear());
        b.setPrice(book.getPrice());
        return bookRepo.save(b);
    }

    @PatchMapping
    public Book partialUpdate(@RequestParam Long id, @RequestParam Double price){
        Book b = bookRepo.findById(id).orElseThrow(()->new RuntimeException("Book not found!"));
        b.setPrice(price);
        return bookRepo.save(b);
    }

    @DeleteMapping
    public Book deleteBook(@RequestParam Long id){
        Book b = bookRepo.findById(id).orElseThrow(()->new RuntimeException("Book not found!"));
        bookRepo.deleteById(id);
        return b;
    }
}
