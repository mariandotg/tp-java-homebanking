package com.example.tpjavahomebanking.models.dtos;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class UserDTO {
    private Long id;

    private String name;

    public String email;

    private String password;

    private String dni;

    private String date;

    private String direction;

    private String count;
}
