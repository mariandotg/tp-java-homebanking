package com.example.tpjavahomebanking.mappers;

import com.example.tpjavahomebanking.models.User;
import com.example.tpjavahomebanking.models.dtos.UserDTO;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserMapper {


    public static User dtoToUser(UserDTO dto){
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setDni(dto.getDni());

        user.setDate(dto.getDate());
        user.setDirection(dto.getDirection());
        user.setCount(dto.getCount());


        return user;
    }

    public static UserDTO userToDto(User user){
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setPassword(user.getPassword());
        dto.setDni(user.getDni());

        dto.setDate(user.getDate());
        dto.setDirection(user.getDirection());
        dto.setCount(user.getCount());


        return dto;
    }


}
