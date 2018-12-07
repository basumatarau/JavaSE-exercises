package com.codeHeap.io.greenHouseControllerV2;

import java.io.File;

public class GreenHouseControllerV2 {
    public static void main(String[] args) {
        String sequenceDoc = System.getProperty("user.dir") + File.separator
                + "src" + File.separator + GreenHouseControllerV2.class.getCanonicalName()
                .replaceAll("\\.", File.separator).replace(GreenHouseControllerV2.class.getSimpleName(),
                        "sequence.txt");
        System.out.println(sequenceDoc);

        GreenHouseControls controls = new GreenHouseControls();
        controls.loadSequenceAndRun(sequenceDoc);
    }
}
