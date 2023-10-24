package com.transactionservice.dao;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "operationtypes")
@Data
@NoArgsConstructor
public class OperationType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="operation_type_id")
    private Long operationTypeId;
    private String description;
}