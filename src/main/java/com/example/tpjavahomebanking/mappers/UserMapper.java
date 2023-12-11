package com.example.tpjavahomebanking.mappers;

import com.example.tpjavahomebanking.models.entity.User;
import com.example.tpjavahomebanking.models.dtos.UserDTO;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserMapper {
    public static UserDTO userToDto(User user){
        return UserDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .password(user.getPassword())
                .dni(user.getDni())
                .date(user.getDate())
                .direction(user.getDirection())
                .count(user.getCount())
                .build();
    }

    public static User dtoToUser(UserDTO dto){
        return User.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .dni(dto.getDni())
                .date(dto.getDate())
                .direction(dto.getDirection())
                .count(dto.getCount())
                .build();
    }


}
