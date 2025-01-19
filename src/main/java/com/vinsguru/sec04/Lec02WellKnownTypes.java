package com.vinsguru.sec04;

import com.google.protobuf.Int32Value;
import com.google.protobuf.Timestamp;
import com.vinsguru.model.sec04.Sample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Instant;

public class Lec02WellKnownTypes {
    private static final Logger logger = LoggerFactory.getLogger(Lec02WellKnownTypes.class);

    public static void main(String[] args) {

        var sample = Sample.newBuilder().setAge(Int32Value.of(45))
                .setLoginTime(Timestamp.newBuilder().setSeconds(Instant.now().getEpochSecond()).build())
                .setYear(2024)
                .setOptionalYear(2024).build();

        logger.info("hasAge {}", sample.hasAge());
//        logger.info("hasYear {}", sample.hasYear());  // not available for scalars
        logger.info("hasOptionalYear {}", sample.hasOptionalYear());
        var sample2 = Sample.newBuilder().build();
        logger.info("hasAge() 2 {}", sample2.hasAge());

        logger.info("hasAge {}", Instant.ofEpochSecond(sample.getLoginTime().getSeconds()));
    }
}