package com.example.tpjavahomebanking.controllers;

import com.example.tpjavahomebanking.models.dtos.TransferDTO;
import com.example.tpjavahomebanking.models.dtos.UserDTO;
import com.example.tpjavahomebanking.models.enums.ActionType;
import com.example.tpjavahomebanking.service.LogService;
import com.example.tpjavahomebanking.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService service;
    private final LogService logService;

    public UserController(UserService service, LogService logService){
        this.service = service;
        this.logService = logService;
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
        UserDTO newUser = service.createUser(user);

        logService.createLog(LocalDateTime.now(), ActionType.CREATED, "Usuario creado con id " + newUser.getId());

        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @RequestBody UserDTO user){
        logService.createLog(LocalDateTime.now(), ActionType.UPDATED, "Usuario modificado con id " + id);

        return ResponseEntity.status(HttpStatus.OK).body(service.updateUser(id, user));
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
        logService.createLog(LocalDateTime.now(), ActionType.DELETED, "Usuario eliminado con id " + id);

        return ResponseEntity.status(HttpStatus.OK).body(service.deleteUser(id));
    }
}
