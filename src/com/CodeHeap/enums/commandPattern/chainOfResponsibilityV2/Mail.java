package com.CodeHeap.enums.commandPattern.chainOfResponsibilityV2;

import com.CodeHeap.enums.Util.Enums;

import java.util.Iterator;

public class Mail {
    enum GeneralDelivery{
        YES, NO1, NO2, NO3, NO4, NO5
    }
    enum Scanability {
        UNSCANNABLE, YES1, YES2, YES3, YES4, YES5
    }
    enum Readability {
        ILLEGIBLE, YES1, YES2, YES3, YES4, YES5
    }
    enum Address {
        INCORRECT, OK1, OK2, OK3, OK4, OK5
    }
    enum ReturnAddress {
        MISSING, OK1, OK2, OK3, OK4, OK5
    }
    GeneralDelivery generalDelivery;
    Scanability scannability;
    Readability readability;
    Address address;
    ReturnAddress returnAddress;

    static long counter = 0;
    private final long id = ++counter;

    @Override
    public String toString() {
        return "Mail#"+id;
    }
    public String deliveryDetails(){
        return toString()
                + ", GenralDelivery " + generalDelivery
                + ", Address Scanability " + scannability
                + ", Address Readability " + readability
                + ", Address Address " + address
                + ", Return Address " + returnAddress;
    }

    public static Mail randomMailGenerator(){
        Mail result = new Mail();
        result.generalDelivery = Enums.random(GeneralDelivery.class);
        result.scannability = Enums.random(Scanability.class);
        result.readability = Enums.random(Readability.class);
        result.address = Enums.random(Address.class);
        result.returnAddress = Enums.random(ReturnAddress.class);

        return result;
    }

    public static Iterable<Mail> generator(final int count){
        return new Iterable<Mail>(){
            int c = count;
            @Override
            public Iterator<Mail> iterator() {
                return new Iterator<Mail>() {
                    @Override
                    public boolean hasNext() {
                        return --c >= 0;
                    }

                    @Override
                    public Mail next() {
                        return randomMailGenerator();
                    }
                };
            }
        };
    }

}
