package com.target.ready.library.system.service.LibrarySystemService.controller;

import com.target.ready.library.system.service.LibrarySystemService.entity.BookCategory;
import com.target.ready.library.system.service.LibrarySystemService.entity.Category;
import com.target.ready.library.system.service.LibrarySystemService.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("library/v2")
public class CategoryController {

    @Autowired
    private final CategoryService categoryService;



    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("inventory/category")
    public ResponseEntity<Category> addCategory(@RequestBody Category category){
        return new ResponseEntity<>(categoryService.addCategory(category), HttpStatus.CREATED);
    }

    @GetMapping("/category/{categoryName}")
    public ResponseEntity<Category> findByCategoryName(@PathVariable String categoryName){
        return new ResponseEntity<>(categoryService.findByCategoryName(categoryName), HttpStatus.OK);
    }

//    @GetMapping("/category/book/{bookId}")
//    public BookCategory findByBookId(@PathVariable int bookId){
//        return categoryService.findByBookId(bookId);
//    }

    @PostMapping("inventory/book/category")
    public ResponseEntity<BookCategory> addBookCategory(@RequestBody BookCategory bookCategory){
        return new ResponseEntity<>(categoryService.addBookCategory(bookCategory), HttpStatus.CREATED);
    }

    @DeleteMapping("inventory/book/category/{id}")
    public ResponseEntity<String> deleteBookCategory(@PathVariable int id){
        return new ResponseEntity<>(categoryService.deleteBookCategory(id), HttpStatus.ACCEPTED);
    }

   @Transactional
    @DeleteMapping("inventory/delete/bookCategory/{id}")
    public ResponseEntity<String> deleteCategories(@PathVariable int id){
       String category="";
        try {
            category=categoryService.deleteCategories(id);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return new ResponseEntity<>(category, HttpStatus.ACCEPTED);
    }
    @GetMapping("/categories/{page_number}/{page_size}")
    public ResponseEntity<List<Category>> findAllCategories(@PathVariable int page_number, @PathVariable int page_size){
        return new ResponseEntity<>(categoryService.findAllCategories(page_number, page_size), HttpStatus.OK);
    }


    @GetMapping("categories/{bookId}")
    public ResponseEntity<List<BookCategory>> findAllCategoriesByBookId(@PathVariable int bookId) {
        List<BookCategory> categories = categoryService.findAllCategoriesByBookId(bookId);

        if (categories.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(categories);
    }

}
