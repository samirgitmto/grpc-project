package com.vinsguru.sec03;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.protobuf.InvalidProtocolBufferException;
import com.vinsguru.model.sec03.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Lec03PerformanceTest {
    private static final Logger logger = LoggerFactory.getLogger(Lec03PerformanceTest.class);

    private static final ObjectMapper objMapper = new ObjectMapper();

    public static void main(String[] args) {
        var protoPerson = Person.newBuilder()
                .setLastName("sam")
                .setAge(28)
                .setEmail("sam@gmail.com")
                .setEmployed(true)
                .setSalary(1000.2345)
                .setBankAccountNumber(12345678)
                .setBalance(-1000)
                .build();

        var jsonPerson = new JsonPerson("sam",
                28, "sam@gmail.com", true,
                1000.2345,
                12345678L,
                -1000);

        for (int i=0; i<5; i++) {
            runTest("json", () -> json(jsonPerson));
            runTest("proto", () -> proto(protoPerson));
        }
    }

    private static void proto(Person person) {
        try {
            var bytes = person.toByteArray();
            Person.parseFrom(bytes);
        } catch (InvalidProtocolBufferException e) {
            throw new RuntimeException(e);
        }
    }

    private static void json(JsonPerson jsonPerson) {
        try {
            var bytes = objMapper.writeValueAsBytes(jsonPerson);
            objMapper.readValue(bytes, JsonPerson.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void runTest(String testName, Runnable runnable) {
        var start = System.currentTimeMillis();
        for (int i=0; i<5_000_000; i++) {
            runnable.run();
        }
        var end = System.currentTimeMillis();
        logger.info("time taken for {} - {} ms", testName, (end - start));
    }
}