package com.target.ready.library.system.service.LibrarySystemService.service;


import com.target.ready.library.system.service.LibrarySystemService.controller.LibraryControllerTest;
import com.target.ready.library.system.service.LibrarySystemService.entity.UserCatalog;
import com.target.ready.library.system.service.LibrarySystemService.entity.UserProfile;
import com.target.ready.library.system.service.LibrarySystemService.repository.UserCatalogRepository;
import com.target.ready.library.system.service.LibrarySystemService.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = {UserServiceTest.class})
public class UserServiceTest {

    @Mock
    UserCatalogRepository userCatalogRepository;

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserService userService;

    @Test
    public void addUserTest(){
        UserProfile user = new UserProfile();
        user.setUserId(1);
        user.setUserName("Rohit");
        when(userRepository.save(user)).thenReturn(user);
        assert(userService.addUser(user).getUserId() == 1);
    }

    @Test
    public void addUserCatalogTest(){
        UserCatalog user = new UserCatalog();
        user.setId(1);
        user.setUserId(1);
        user.setBookId(1);
        when(userCatalogRepository.save(user)).thenReturn(user);
        assert(userService.addUserCatalog(user).getId() == 1);
    }

}






