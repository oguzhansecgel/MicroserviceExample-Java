package com.javaexample.CustomerService.Entity;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CUSTOMERS")
@ToString
public class Customer {

    @Id
    @Column(name = "CUSTOMERID", nullable = false)
    private Long customerId;

    @Column(name = "CUSTOMERNAME", length = 50)
    private String customerName;

    @Column(name = "CUSTOMERSURNAME", length = 50)
    private String customerSurname;
}