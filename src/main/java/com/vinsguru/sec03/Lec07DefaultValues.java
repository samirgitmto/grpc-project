package com.vinsguru.sec03;

import com.vinsguru.model.sec03.Address;
import com.vinsguru.model.sec03.Car;
import com.vinsguru.model.sec03.School;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Lec07DefaultValues {
    private static final Logger logger = LoggerFactory.getLogger(Lec07DefaultValues.class);

    public static void main(String[] args) {
        var school = School.newBuilder().build();
        logger.info("{}", school.getId());
        logger.info("{}", school.getAddress());
        logger.info("{}", school.getAddress().getCity());
        logger.info("{}", school.getAddress().getStreet());

        logger.info("is equal {}", school.getAddress().equals(Address.getDefaultInstance()));

        logger.info("has address {}", school.hasAddress());
        var school2 = School.newBuilder().setAddress(Address.newBuilder().setCity("Delhi").build()).build();
        logger.info("has address 2 {}", school2.hasAddress());

        var car = Car.newBuilder().build();
        logger.info("body style {} ", car.getBodyStyle());
    }

}
