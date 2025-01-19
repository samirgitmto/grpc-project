package com.vinsguru.sec05;

import com.google.protobuf.InvalidProtocolBufferException;
import com.vinsguru.model.sec05.v2.Television;
import com.vinsguru.model.sec05.v2.Type;
import com.vinsguru.sec05.parser.V1Parser;
import com.vinsguru.sec05.parser.V2Parser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class V2VersionCompatiability {
    private static final Logger logger = LoggerFactory.getLogger(V2VersionCompatiability.class);

    public static void main(String[] args) throws InvalidProtocolBufferException {
        var tv = Television.newBuilder()
                .setBrand("samsung")
                .setModel(2024)
                .setType(Type.OLED)
                .build();

        V2Parser.parse(tv.toByteArray());
        V1Parser.parse(tv.toByteArray());
    }
}