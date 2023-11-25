package com.example.tpjavahomebanking.models.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDtos {

    private Long id;

    private String email;

    private String password;

    private String name;

    private String surname;

    private String dni;


}
