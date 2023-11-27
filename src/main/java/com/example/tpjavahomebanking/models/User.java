package com.example.tpjavahomebanking.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Nombre_de_Usuario")
    private String name;

    @Column(name = "Mail")
    private String email;

    @Column(name = "Contrasena")
    private String password;

    @Column(name= "Dni")
    private String dni;

    @Column(name="Fecha_de_nacimiento")
    private String date;

    @Column(name="Domicilio")
    private String direction;

    @Column(name="listado_de_cuentas")
    private String count;


}
