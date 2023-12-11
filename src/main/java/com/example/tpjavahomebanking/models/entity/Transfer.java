package com.example.tpjavahomebanking.models.entity;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Transfer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transfer id")

    private Long id;
    private Long origin;
    private Long target;
    private Date date;

    private BigDecimal amount;

}

