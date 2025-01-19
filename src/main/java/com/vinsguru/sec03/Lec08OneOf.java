package com.vinsguru.sec03;

import com.vinsguru.model.sec03.Credentials;
import com.vinsguru.model.sec03.Email;
import com.vinsguru.model.sec03.Phone;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Lec08OneOf {
    private static final Logger logger = LoggerFactory.getLogger(Lec08OneOf.class);

    public static void main(String[] args) {
        var email = Email.newBuilder().setAddress("xyz").setPassword("123").build();
        var phone = Phone.newBuilder().setNumber(987654).setCode(789).build();

        login(Credentials.newBuilder().setEmail(email).build());
        login(Credentials.newBuilder().setPhone(phone).build());
        login(Credentials.newBuilder().setEmail(email).build());
    }

    private static void login(Credentials credentials) {
        // getLoginTypeCase()
        switch (credentials.getLoginTypeCase()) {
            case EMAIL -> logger.info("email -> {}", credentials.getEmail());
            case PHONE -> logger.info("phone -> {}", credentials.getPhone());
        }
    }
}