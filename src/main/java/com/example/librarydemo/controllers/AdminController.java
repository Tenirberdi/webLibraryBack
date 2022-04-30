package com.example.librarydemo.controllers;


import com.example.librarydemo.models.User;
import com.example.librarydemo.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    private UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    //Выводит список всех пользователей программы вне зависимости от родей
    @GetMapping("/all_users")
    public List<User> listOfUsers(){
        return userService.UserList();
    }

    //Выводит информацию об одном пользователе
    @GetMapping("/all_users/{id}")
    public User getUser(@PathVariable("id") int id){
        return userService.oneUser(id);
    }


    //Удаление пользователя
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") int id){
        userService.deleteUser(id);
        return new ResponseEntity<String>("User deleted successfully", HttpStatus.OK);
    }
    //Добавить одного нового пользователя
    @PostMapping("/add-student")
    public ResponseEntity<User> addStudent(@RequestBody User user){
        return new ResponseEntity<User>(userService.createStudent(user), HttpStatus.CREATED);
    }


    //Создание нового пользователя
    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User user){
        return new ResponseEntity<User>(userService.createUser(user), HttpStatus.CREATED);
    }



















    //    //Добавить одного нового пользователя
//    @PostMapping("/add-student")
//    public ResponseEntity<User> addStudent(@RequestBody StudentDTO studentDTO){
//        return new ResponseEntity<User>(userService.createStudent(studentDTO), HttpStatus.CREATED);
//    }
    //    @GetMapping("/student/{id}")
//    public StudentDTO getStudent(@PathVariable("id") int id){
//        return userService.allInformationAboutOneStudent(id);
//    }
//
//
//
//    @GetMapping("/lib/{id}")
//    public LibrarianAdminDTO getLibr(@PathVariable("id") int id){
//        return userService.allInformationAboutOneLibrarian(id);
//    }



















}
