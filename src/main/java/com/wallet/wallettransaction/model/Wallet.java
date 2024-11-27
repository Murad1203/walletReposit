package com.wallet.wallettransaction.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private String lastname;
    private BigDecimal balance;
}
