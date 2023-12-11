package com.example.tpjavahomebanking.mappers;

import com.example.tpjavahomebanking.models.dtos.LogDTO;
import com.example.tpjavahomebanking.models.entity.Log;
import lombok.experimental.UtilityClass;

@UtilityClass
public class LogMapper {
    public LogDTO logToDto(Log log){
        return LogDTO.builder()
                .message(log.getMessage())
                .date(log.getDate())
                .action(log.getAction())
                .id(log.getId()).build();
    }

    public Log dtoToLog(LogDTO dto){
        return Log.builder()
                .message(dto.getMessage())
                .date(dto.getDate())
                .action(dto.getAction())
                .build();
    }
}
