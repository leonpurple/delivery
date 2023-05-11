package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    private String personID;
    private String name;
    private String surname;
    private Integer aye;
    private String address;
    private Integer phone;
}