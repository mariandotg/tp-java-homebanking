package com.example.tpjavahomebanking.controllers;



import com.example.tpjavahomebanking.models.dtos.TransferDTO;
import com.example.tpjavahomebanking.service.TransferService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transfers")
public class TransferController {

    private final TransferService service;

    public TransferController(TransferService service){
        this.service = service;
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
        return ResponseEntity.status(HttpStatus.CREATED).body(service.performTransfer(dto));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<TransferDTO> updateTransfer(@PathVariable Long id, @RequestBody TransferDTO transfer){
        return ResponseEntity.status(HttpStatus.OK).body(service.updateTransfer(id, transfer));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteTransfer(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.deleteTransfer(id));
    }
}