package com.example.tpjavahomebanking.controllers;

import com.example.tpjavahomebanking.models.dtos.AccountDTO;
import com.example.tpjavahomebanking.models.entity.Account;
import com.example.tpjavahomebanking.models.enums.ActionType;
import com.example.tpjavahomebanking.service.AccountService;
import com.example.tpjavahomebanking.service.LogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    private final AccountService service;
    private final LogService logService;

    public AccountController(AccountService service, LogService logService){
        this.service = service;
        this.logService = logService;
    }

    @GetMapping
    public ResponseEntity<List<AccountDTO>> getAccounts(){
        List<AccountDTO> lista = service.getAccounts();
        return ResponseEntity.status(HttpStatus.OK).body(lista);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<AccountDTO> getAccount(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.getAccountById(id));
    }

    @PostMapping
    public ResponseEntity<AccountDTO> createAccount(@RequestBody AccountDTO dto){
        AccountDTO newAccount = service.createAccount(dto);

        logService.createLog(LocalDateTime.now(), ActionType.CREATED, "Cuenta creada con id " + newAccount.getId());

        return ResponseEntity.status(HttpStatus.CREATED).body(newAccount);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<AccountDTO> updateAccount(@PathVariable Long id, @RequestBody AccountDTO dto){
        logService.createLog(LocalDateTime.now(), ActionType.UPDATED, "Cuenta modificada con id " + id);

        return ResponseEntity.status(HttpStatus.OK).body(service.updateAccount(id, dto));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long id){
        logService.createLog(LocalDateTime.now(), ActionType.DELETED, "Cuenta eliminada con id " + id);

        return ResponseEntity.status(HttpStatus.OK).body(service.deleteAccount(id));
    }

}
