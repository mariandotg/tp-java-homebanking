package com.example.tpjavahomebanking.service;

import com.example.tpjavahomebanking.mappers.LogMapper;
import com.example.tpjavahomebanking.models.dtos.LogDTO;
import com.example.tpjavahomebanking.models.entity.Log;
import com.example.tpjavahomebanking.models.enums.ActionType;
import com.example.tpjavahomebanking.repositories.LogRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class LogService {
    private final LogRepository repository;

    public LogService(LogRepository repository) {
        this.repository = repository;
    }

    public LogDTO createLog(LocalDateTime date, ActionType action, String message) {
        LogDTO logDTO = LogDTO.builder().date(date).action(action).message(message).build();
        Log newLog = repository.save(LogMapper.dtoToLog(logDTO));
        return LogMapper.logToDto(newLog);
    }

}
