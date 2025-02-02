package com.target.ready.library.system.service.LibrarySystemService.controller;

import com.target.ready.library.system.service.LibrarySystemService.entity.Book;
import com.target.ready.library.system.service.LibrarySystemService.service.LibrarySystemService;
import org.springframework.beans.factory.annotation.Autowired;

import com.target.ready.library.system.service.LibrarySystemService.entity.Inventory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("library/v1/")
public class LibrarySystemController {

    @Autowired
    private final LibrarySystemService librarySystemService;


    public LibrarySystemController(LibrarySystemService librarySystemService) {
        this.librarySystemService = librarySystemService;
    }

    @GetMapping("books_directory/{page_number}/{page_size}")
    public ResponseEntity<List<Book>> getAllBooks(@PathVariable int page_number, @PathVariable int page_size) {
        return new ResponseEntity<>(librarySystemService.getAllBooks(page_number,page_size),HttpStatus.OK);
    }

    @PostMapping("inventory/books")
    public ResponseEntity<Book> addBook(@RequestBody Book book){
        return new ResponseEntity<>(librarySystemService.addBook(book), HttpStatus.CREATED);
    }

    @DeleteMapping("book/{bookId}")
    public ResponseEntity<String> deleteBook(@PathVariable int bookId) {
        return new ResponseEntity<>(librarySystemService.deleteBook(bookId), HttpStatus.ACCEPTED);
    }

    @GetMapping("book/{bookId}")
    public ResponseEntity<Book> findByBookId(@PathVariable int bookId) {

        return new ResponseEntity<>(librarySystemService.findByBookId(bookId), HttpStatus.OK);
    }


    @GetMapping("book/category/{categoryName}")
    public ResponseEntity<List<Book>> findBookByCategoryName(@PathVariable String categoryName){
        return new ResponseEntity<>(librarySystemService.findBookByCategoryName(categoryName), HttpStatus.OK);
    }

    @GetMapping("books/{bookName}")
    public ResponseEntity<List<Book>> findByBookName(@PathVariable String bookName) {
        return new ResponseEntity<>(librarySystemService.findByBookName(bookName), HttpStatus.OK);
    }

    @PutMapping("inventory/book/update/{id}")
    public ResponseEntity<Book> updateBookDetails(@PathVariable("id") int id, @RequestBody Book book ){
        return new ResponseEntity<>(librarySystemService.updateBookDetails(id,book), HttpStatus.OK);
    }

    @GetMapping("inventory/book/{bookId}")
    public ResponseEntity<Inventory> getBookById(@PathVariable int bookId){
        return new ResponseEntity<>(librarySystemService.getBookById(bookId), HttpStatus.OK);
    }

    @PostMapping("inventory")
    public ResponseEntity<Inventory> addInventory(@RequestBody Inventory inventory){
        return new ResponseEntity<>(librarySystemService.addInventory(inventory), HttpStatus.CREATED);
    }




}