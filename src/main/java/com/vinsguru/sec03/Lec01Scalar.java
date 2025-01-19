package com.vinsguru.sec03;

import com.vinsguru.model.sec03.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Lec01Scalar {

    private static final Logger logger = LoggerFactory.getLogger(Lec01Scalar.class);

    public static void main(String[] args) {

        var person = Person.newBuilder()
                .setLastName("sam")
                .setAge(28)
                .setEmail("sam@gmail.com")
                .setEmployed(true)
                .setBankAccountNumber(12345678)
                .setBalance(-1000)
                .build();

        logger.info("{}", person);

    }
}
