package com.vinsguru.sec04;

import com.vinsguru.model.sec04.Person;
import com.vinsguru.model.sec04.common.Address;
import com.vinsguru.model.sec04.common.BodyStyle;
import com.vinsguru.model.sec04.common.Car;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Lec01Import {
    private static final Logger logger = LoggerFactory.getLogger(Lec01Import.class);

    public static void main(String[] args) {

        var address = Address.newBuilder().setCity("Atlanta").build();
        var car = Car.newBuilder().setBodyStyle(BodyStyle.COUPE).build();

        var person = Person.newBuilder().setLastName("Bond")
                .setAge(45)
                .setAddress(address)
                .setCar(car).build();

        logger.info("{}", person);
    }
}