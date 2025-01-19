package com.vinsguru.sec03;

import com.vinsguru.model.sec03.BodyStyle;
import com.vinsguru.model.sec03.Car;
import com.vinsguru.model.sec03.Dealer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Lec06Map {
    private static final Logger logger = LoggerFactory.getLogger(Lec06Map.class);

    public static void main(String[] args) {

        var car1 = Car.newBuilder()
                .setMake("honda").setModel("civic")
                .setBodyStyle(BodyStyle.COUPE)
                .setYear(2000).build();

//        var car2 = car1.toBuilder()
//                .setModel("accord").setYear(2002)
//                .setBodyStyle(BodyStyle.SEDAN)
//                .build();

        var car2 = Car.newBuilder()
                .setMake("honda")
                .setModel("accord").setYear(2002)
                .setBodyStyle(BodyStyle.SEDAN)
//                .setBodyStyle(BodyStyle.SUV)
                .build();
/*
The output you’re seeing suggests that the BodyStyle field in car2 is not being serialized or is missing in the
 final output. This likely happens because of the default behavior in Protocol Buffers where fields with
  values (like 0 for enums) are often omitted in the serialized output to save space.
 */
        var dealer = Dealer.newBuilder()
                .putInventory(car1.getYear(), car1)
                .putInventory(car2.getYear(), car2)
                .build();

        logger.info("{}", dealer);
        logger.info("{}", car2.getBodyStyle());

    }

}