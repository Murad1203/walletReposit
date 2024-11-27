package com.wallet.wallettransaction.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(name = "operation_type")
    private OperationType operationType;
    @Column(name = "date_time")
    private LocalDateTime dateTime;

    private String wallet;

    private BigDecimal amount;
}
