package com.vinsguru.sec03;

import com.vinsguru.model.sec03.Address;
import com.vinsguru.model.sec03.School;
import com.vinsguru.model.sec03.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Lec04Composition {
    private static final Logger logger = LoggerFactory.getLogger(Lec04Composition.class);

    public static void main(String[] args) {

        var address = Address.newBuilder()
                .setStreet("123 main st")
                .setCity("Atlanta")
                .setState("GA")
                .build();

        var student = Student.newBuilder()
                .setName("sam")
                .setAddress(address)
                .build();

        var school = School.newBuilder()
                .setId(1)
                .setName("High School")
                .setAddress(address.toBuilder().setStreet("789 School st"))
                .build();

        logger.info("school {}", school);
        logger.info("student {}", student);
    }
}