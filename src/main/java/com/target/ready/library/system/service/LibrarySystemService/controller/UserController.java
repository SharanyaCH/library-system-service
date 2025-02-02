package com.target.ready.library.system.service.LibrarySystemService.controller;

import com.target.ready.library.system.service.LibrarySystemService.entity.UserCatalog;
import com.target.ready.library.system.service.LibrarySystemService.entity.UserProfile;
import com.target.ready.library.system.service.LibrarySystemService.repository.UserCatalogRepository;
import com.target.ready.library.system.service.LibrarySystemService.repository.UserRepository;
import com.target.ready.library.system.service.LibrarySystemService.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("library/v3/")
public class UserController {

    @Autowired
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }


    @GetMapping("user/books/{userId}")
    public ResponseEntity<List<Integer>> findBooksByUserId(@PathVariable int userId){
        return new ResponseEntity<>(userService.findBooksByUserId(userId), HttpStatus.OK);
    }

    @DeleteMapping("user/books/{userId}/{bookId}")
    @Transactional
    public ResponseEntity<Integer> deleteBookByUserId(@PathVariable int userId, @PathVariable int bookId){
         return new ResponseEntity<>(userService.deleteBookByUserId(userId, bookId), HttpStatus.OK);
    }

    @PostMapping("user/catalog")
    public ResponseEntity<UserCatalog> addUserCatalog(@RequestBody UserCatalog userCatalog){
        return new ResponseEntity<>(userService.addUserCatalog(userCatalog), HttpStatus.CREATED);
    }

    @PostMapping("user")
    public ResponseEntity<UserProfile> addUser(@RequestBody UserProfile userProfile){

        return new ResponseEntity<>(userService.addUser(userProfile), HttpStatus.CREATED);
    }
}
