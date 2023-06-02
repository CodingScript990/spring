package com.example.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // table 역할 하는 어노테이션
public class Person {
    @Id // PK 설정
    @GeneratedValue(strategy = GenerationType.AUTO) // 일련번호주는 역할
    private Long id;

    private String firstName;
    private String lastName;

    // Getter
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    // Setter
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
