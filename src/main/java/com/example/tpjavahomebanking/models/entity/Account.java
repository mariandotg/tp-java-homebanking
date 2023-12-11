package com.example.tpjavahomebanking.models.entity;

import com.example.tpjavahomebanking.models.enums.AccountType;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cuentas")
@Getter
@Setter
@Builder
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "account_type")
    private AccountType type;

    private String cbu;

    private String alias;

    private BigDecimal amount;

    @ManyToOne
    private User owner;
}
