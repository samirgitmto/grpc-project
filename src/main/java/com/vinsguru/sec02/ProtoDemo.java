package com.vinsguru.sec02;

//import com.vinsguru.model.sec01.Person;
import com.vinsguru.model.sec02.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProtoDemo {

    private static final Logger logger = LoggerFactory.getLogger(ProtoDemo.class);

    public static void main(String[] args) {

        var person1 = createPerson();

        var person2 = createPerson();

        // compare
        logger.info("equals {}", person1.equals(person2));
        logger.info("== {}", (person1 == person2));

        // mutable? No
//        person1.setAge();

        // create another instance with diff values
        var person3 = person1.toBuilder().setName("Mike").build();

        // compare
        logger.info("equals {}", person1.equals(person3));
        logger.info("== {}", person1 == person3);
        logger.info("person3 {}", person3);

        // null
        var person4B = person1.toBuilder().clearName().build();
        logger.info("person4: {}", person4B);    // person4: age: 28


        // NPE
        var person4 = person1.toBuilder().setName(null).build();
        logger.info("person4: {}", person4);
    }

    private static Person createPerson() {
        return Person.newBuilder()
                .setName("sam")
                .setAge(28)
                .build();
    }
}
