package com.javatechie.reactive.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "bank_accounts_plazofijo")
public class BankAccountPlazoFijo {

	@Id
    private String id;
    private double saldo;
    private long pan;
    private int cvv;
    private List<String> movements;
}
