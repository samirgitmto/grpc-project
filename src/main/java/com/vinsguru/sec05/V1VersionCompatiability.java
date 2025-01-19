package com.vinsguru.sec05;

import com.google.protobuf.InvalidProtocolBufferException;
import com.vinsguru.model.sec05.v1.Television;
import com.vinsguru.sec05.parser.V1Parser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class V1VersionCompatiability {
    private static final Logger logger = LoggerFactory.getLogger(V1VersionCompatiability.class);

    public static void main(String[] args) throws InvalidProtocolBufferException {
        var tv = Television.newBuilder()
                .setBrand("samsung")
                .setYear(2024)
                .build();

        V1Parser.parse(tv.toByteArray());
    }
}