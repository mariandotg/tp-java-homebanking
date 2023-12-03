package com.example.tpjavahomebanking.mappers;

import com.example.tpjavahomebanking.models.User;
import com.example.tpjavahomebanking.models.dtos.UserDTO;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserMapper {

/*
    public static User dtoToUser(UserDTO dto){
        return User.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .origin(dto.getOrigin())
                .password(dto.getPassword())
                .dni(dto.getDni())
                .date(dto.getDate())
                .build();
    }
*/

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





 /*

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

 */

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
