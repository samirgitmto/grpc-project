package com.vinsguru.sec03;

import com.vinsguru.model.sec03.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Lec02Serialization {
    private static final Logger logger = LoggerFactory.getLogger(Lec02Serialization.class);
    private static final Path PATH = Path.of("person.out");

    public static void main(String[] args) throws IOException {

        var person = Person.newBuilder()
                .setLastName("sam")
                .setAge(28)
                .setEmail("sam@gmail.com")
                .setEmployed(true)
                .setBankAccountNumber(12345678)
                .setBalance(-1000)
                .build();

        var person2 = Person.newBuilder()
//                .setAge(28333)  // 4 bytes
//                .setAge(28)  // 2 bytes
//                .setEmployed(true) // 2 bytes
                .setEmployed(false) // 0 byte
                .build();

//        logger.info("{}", person);

        serialize(person);
        logger.info("on deserialization {}", deserialize());
        logger.info("equals: {}", person.equals(deserialize()));
        logger.info("bytes length: {}", person.toByteArray().length);
        logger.info("person2 bytes length: {}", person2.toByteArray().length);
    }

    public static void serialize(Person person) throws IOException {
        try (var stream = Files.newOutputStream(PATH)) {
            person.writeTo(stream);
        }
    }

    public static Person deserialize() throws IOException {
        try (var stream = Files.newInputStream(PATH)) {
            return Person.parseFrom(stream);
        }
    }
}