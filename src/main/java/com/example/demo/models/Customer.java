package com.example.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // table 접근 => DB
public class Customer {
    // Member Field
    @Id // PK 설정
    @GeneratedValue(strategy = GenerationType.AUTO) // 일련번호주는 역할
    private Long id;

    private String firstName;
    private String lastName;

    // Customer 생성자
    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Default Customer
    public Customer() {}

    // Data String Formatting
    @Override
    public String toString() {
        return String.format("Customer[id=%d, firstName=%s, lastName=%s]", id, firstName, lastName);
    }

    // Getter
    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
