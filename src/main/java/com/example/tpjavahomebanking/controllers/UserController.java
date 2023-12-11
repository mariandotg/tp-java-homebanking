package com.example.tpjavahomebanking.controllers;

import com.example.tpjavahomebanking.models.dtos.UserDTO;
import com.example.tpjavahomebanking.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService service;

    public UserController(UserService service){
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getUsers(){
        List<UserDTO> lista = service.getUsers();
        return ResponseEntity.status(HttpStatus.OK).body(lista);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.getUserById(id));
    }

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO user){
        return  ResponseEntity.status(HttpStatus.CREATED).body(service.createUser(user));
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @RequestBody UserDTO user){
        return ResponseEntity.status(HttpStatus.OK).body(service.updateUser(id, user));
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.deleteUser(id));
    }
}
