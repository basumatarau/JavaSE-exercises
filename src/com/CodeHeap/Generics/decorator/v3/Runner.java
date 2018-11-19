package com.CodeHeap.Generics.decorator.v3;
import static com.CodeHeap.Generics.decorator.v3.TwoTuple.*;

public class Runner {
    public static void main(String[] args) {
        Object proxy = MixinProxy.newInstance(
                makeTuple(new BasicImplementation(), Basic.class),
                makeTuple(new NumberedImplementation(), SerialNumbered.class),
                makeTuple(new StampedImplementation(), TimeStamped.class)
        );

        System.out.println(((Basic)proxy).get());
        System.out.println(((SerialNumbered)proxy).getId());
        System.out.println(((TimeStamped)proxy).getTimeStamp());
    }
}
