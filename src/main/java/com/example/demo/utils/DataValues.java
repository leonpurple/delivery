package com.example.demo.utils;

import java.util.UUID;

public class DataValues {

    public static int personID = 99;


    public static int getIdNumber() {
        return personID;
    }

    public static int setIdNumber(int num){
        return personID = num;
    }

    // https://docs.oracle.com/javase/8/docs/api/java/util/UUID.html
    public static String createUUID(){
        UUID uuid = UUID.randomUUID();
        //System.out.println("UUID generated - " + uuid);
        //System.out.println("UUID Version - " + uuid.version());
        return uuid.toString();
    }
}
