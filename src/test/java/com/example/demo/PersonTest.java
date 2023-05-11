package com.example.demo;

import com.example.demo.model.Person;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonTest {


    private final Person person = new Person("personID", "Fabricio", "Cruz", 45,"CiutatdelaVilla",3415251);



    @Test
    public void getPerson() {
        assertAll("person",
                () -> assertEquals("personID", person.getPersonID()),
                () -> assertEquals("Fabricio", person.getName()),
                () -> assertEquals("Cruz", person.getSurname()),
                () -> assertEquals(45, person.getAye()),
                () -> assertEquals("CiutatdelaVilla", person.getAddress()),
                () -> assertEquals(3415251, person.getPhone())
        );

        System.out.println(person);
        }
    }


