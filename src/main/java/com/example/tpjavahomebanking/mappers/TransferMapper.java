package com.example.tpjavahomebanking.mappers;

import com.example.tpjavahomebanking.models.entity.Transfer;
import com.example.tpjavahomebanking.models.dtos.TransferDTO;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TransferMapper {
    public Transfer dtoToTransfer(TransferDTO dto){
        return Transfer.builder()
                .amount(dto.getAmount())
                .date(dto.getDate())
                .origin(dto.getOrigin())
                .target(dto.getTarget())
                .build();
    }

    public TransferDTO transferToDto(Transfer transfer){
        return TransferDTO.builder()
                .id(transfer.getId())
                .amount(transfer.getAmount())
                .target(transfer.getTarget())
                .origin(transfer.getOrigin())
                .date(transfer.getDate())
                .build();
    }
}