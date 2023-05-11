package com.example.demo.service;


import com.example.demo.manager.PersonManager;
import com.example.demo.model.Person;
import com.example.demo.utils.DataValues;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PersonService {

    public static Map<String, Person> persons = new HashMap<>();

    static {
        PersonManager.createPersons(persons, 20);
    }

    public Map<String, Person> getAllPersons() {
        return persons;
    }

    public void createPerson(Person person) {
        int sumNewMaxId = DataValues.getIdNumber();
        String stringSumNewMaxId = String.format("%04d", sumNewMaxId);
        person.setPersonID(stringSumNewMaxId);
        persons.put(stringSumNewMaxId, person);
        DataValues.setIdNumber(sumNewMaxId + 1);
    }

    public Person getPerson(String id) {
        return persons.get(id);
    }

    public void updatePerson(String id, Person person) {
        person.setPersonID(id);
        persons.put(id, person);
    }

    public void deletePerson(String id) {
        persons.remove(id);
    }
}


