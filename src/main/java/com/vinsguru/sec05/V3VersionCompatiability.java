package com.vinsguru.sec05;

import com.google.protobuf.InvalidProtocolBufferException;
import com.vinsguru.model.sec05.v3.Television;
import com.vinsguru.model.sec05.v3.Type;
import com.vinsguru.sec05.parser.V1Parser;
import com.vinsguru.sec05.parser.V2Parser;
import com.vinsguru.sec05.parser.V3Parser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class V3VersionCompatiability {
    private static final Logger logger = LoggerFactory.getLogger(V3VersionCompatiability.class);

    public static void main(String[] args) throws InvalidProtocolBufferException {
        var tv = Television.newBuilder()
                .setBrand("samsung")
//                .setModel(2024)
                .setType(Type.OLED)
                .build();

        V1Parser.parse(tv.toByteArray());
        V2Parser.parse(tv.toByteArray());
        V3Parser.parse(tv.toByteArray());

    }
}
