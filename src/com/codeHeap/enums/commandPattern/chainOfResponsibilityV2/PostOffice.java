package com.codeHeap.enums.commandPattern.chainOfResponsibilityV2;

import java.util.EnumMap;
import java.util.Map;

public class PostOffice {

    interface IHandler{
        boolean handle(Mail mail);
    }

    public static EnumMap<MailHandler, IHandler> handlers = new EnumMap<>(MailHandler.class);

    static {
        handlers.put(
                MailHandler.GENERAL_DELIVERY, (mail -> {
                    switch (mail.generalDelivery) {
                        case YES:
                            System.out.println("Using general delivery for mail " + mail);
                            return true;
                        default:
                            return false;
                    }
                })
        );
        handlers.put(MailHandler.MACHINE_SCAN, (mail -> {
            switch (mail.scannability) {
                case UNSCANNABLE:
                    return false;
                default:
                    switch (mail.address) {
                        case INCORRECT:
                            return false;
                        default:
                            System.out.println("delivering automatically");
                            return true;
                    }
            }
        }));
        handlers.put(MailHandler.VISUAL_INSPECTION, (mail -> {
            switch (mail.readability) {
                case ILLEGIBLE:
                    return false;
                default:
                    switch (mail.address) {
                        case INCORRECT:
                            return false;
                        default:
                            System.out.println("Delivering " + mail + " normally");
                            return true;
                    }
            }
        }));
        handlers.put(MailHandler.RETURN_TO_SANDER, (mail -> {
            switch (mail.returnAddress) {
                case MISSING:
                    return false;
                default:
                    System.out.println("Returning the letter " + mail + " to sender");
                    return true;
            }
        }));
    }

    enum MailHandler {
        GENERAL_DELIVERY,
        MACHINE_SCAN,
        VISUAL_INSPECTION,
        RETURN_TO_SANDER
    }

    public static void handle(Mail m) {
        for (Map.Entry<MailHandler, IHandler> handlerEntry : handlers.entrySet()) {
            if(handlerEntry.getValue().handle(m)){
                return;
            }
        }
        System.out.println(m + " is dead...");
    }

    public static void main(String[] args) {
        for (Mail mail : Mail.generator(100)) {
            System.out.println(mail.deliveryDetails());
            handle(mail);
            System.out.println("*****");
        }
    }
}
