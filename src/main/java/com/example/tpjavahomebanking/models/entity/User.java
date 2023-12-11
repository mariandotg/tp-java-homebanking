package com.example.tpjavahomebanking.models.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
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

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Account> accounts;
}
