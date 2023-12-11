package com.example.tpjavahomebanking.controllers;

import com.example.tpjavahomebanking.models.dtos.TransferDTO;
import com.example.tpjavahomebanking.models.enums.ActionType;
import com.example.tpjavahomebanking.service.LogService;
import com.example.tpjavahomebanking.service.TransferService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/transfers")
public class TransferController {
    private final TransferService service;
    private final LogService logService;

    public TransferController(TransferService service, LogService logService){
        this.service = service;
        this.logService = logService;
    }

    @GetMapping
    public ResponseEntity<List<TransferDTO>> getTransfers(){
        List<TransferDTO> transfers = service.getTransfers();
        return ResponseEntity.status(HttpStatus.OK).body(transfers);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TransferDTO> getTransferById(@PathVariable Long id){
        TransferDTO transfer = service.getTransferById(id);
        return ResponseEntity.status(HttpStatus.OK).body(transfer);
    }

    @PostMapping
    public ResponseEntity<TransferDTO> performTransfer(@RequestBody TransferDTO dto){
        TransferDTO newTransfer = service.performTransfer(dto);

        logService.createLog(LocalDateTime.now(), ActionType.CREATED, "Transferencia creada con id " + newTransfer.getId());

        return ResponseEntity.status(HttpStatus.CREATED).body(newTransfer);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<TransferDTO> updateTransfer(@PathVariable Long id, @RequestBody TransferDTO transfer){
        logService.createLog(LocalDateTime.now(), ActionType.UPDATED, "Transferencia modificada con id " + id);

        return ResponseEntity.status(HttpStatus.OK).body(service.updateTransfer(id, transfer));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteTransfer(@PathVariable Long id){
        logService.createLog(LocalDateTime.now(), ActionType.DELETED, "Transferencia eliminada con id " + id);

        return ResponseEntity.status(HttpStatus.OK).body(service.deleteTransfer(id));
    }
}