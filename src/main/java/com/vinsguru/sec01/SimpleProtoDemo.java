package com.vinsguru.sec01;

import com.vinsguru.model.sec01.PersonOuterClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleProtoDemo {

    private static final Logger logger = LoggerFactory.getLogger(SimpleProtoDemo.class);

    public static void main(String[] args) {

        var person = PersonOuterClass.Person.newBuilder()
                .setName("Sam")
                .setAge(28)
                .build();

        logger.info("{}", person);
    }
}