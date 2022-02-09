package com.example.Credit.model;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@Builder
@Entity
@Getter
@Setter
public class Credit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer creditId;   //int
    private String creditName;
    private Long customerID;
    @Column(name = "CREDIT_VALUE")
    private Double value;

    public Credit() {
    }

    public Credit(String creditName, Long customerID, Double value) {
        this.creditName = creditName;
        this.customerID = customerID;
        this.value = value;
    }
}
