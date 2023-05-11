package com.example.demo.manager;

import com.example.demo.model.Person;
import com.example.demo.utils.DataValues;
import com.github.javafaker.Faker;

import java.util.Map;

public class PersonManager {


    public static void createPersons(Map<String, Person> personsToMap, int personsNumber){

        Faker faker = new Faker();
        int sumNewMaxId = DataValues.getIdNumber();

        for (int i = 0; i < personsNumber; i++) {
            Person newPerson = new Person(
                    faker.idNumber().valid(),
                    faker.name().firstName(),
                    faker.name().lastName(),
                    faker.number().numberBetween(21,30),
                    faker.address().fullAddress(),
                    faker.number().numberBetween(20000000, 90000000)


            );

            newPerson.setPersonID(String.format("%04d",sumNewMaxId));
            sumNewMaxId++;

            personsToMap.put(newPerson.getPersonID(), newPerson);
            //System.out.println(newUser);

        }

        DataValues.setIdNumber(sumNewMaxId);
    }
}





