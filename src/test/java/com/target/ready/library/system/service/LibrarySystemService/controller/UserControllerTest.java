package com.target.ready.library.system.service.LibrarySystemService.controller;

import com.target.ready.library.system.service.LibrarySystemService.entity.UserCatalog;
import com.target.ready.library.system.service.LibrarySystemService.entity.UserProfile;
import com.target.ready.library.system.service.LibrarySystemService.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = {UserControllerTest.class})
public class UserControllerTest {

    @Mock
    UserService userService;

    @InjectMocks
    UserController userController;

   @Test
   public void addUserTest(){
       UserProfile user = new UserProfile();
       user.setUserId(1);
       user.setUserName("Rohit");
       when(userService.addUser(user)).thenReturn(user);
       ResponseEntity<UserProfile> response = userController.addUser(user);
       assertEquals(HttpStatus.CREATED, response.getStatusCode());
   }

   @Test
   public void addUserCatalogTest(){
       UserCatalog user = new UserCatalog();
       user.setBookId(1);
       user.setId(1);
       user.setUserId(1);
       when(userService.addUserCatalog(user)).thenReturn(user);
       ResponseEntity<UserCatalog> response = userController.addUserCatalog(user);
       assertEquals(HttpStatus.CREATED, response.getStatusCode());
   }

}
