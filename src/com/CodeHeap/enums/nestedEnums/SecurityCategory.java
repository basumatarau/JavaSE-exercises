package com.CodeHeap.enums.nestedEnums;

import com.CodeHeap.enums.Util.Enums;

public enum SecurityCategory {
    BOND(Security.Bond.class), STOCK(Security.Stock.class);

    public interface Security {
        enum Stock implements Security {
            SHORT, LONG, MARGINAL;
        }

        enum Bond implements Security {
            MUNICIPAL, JUNK;
        }
    }

    Security[] values;

    SecurityCategory(Class<? extends Security> securityType) {
        values = securityType.getEnumConstants();
    }

    public Security randomSelection(){
        return Enums.random(values);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            SecurityCategory category = Enums.random(SecurityCategory.class);
            System.out.println(category + ": " + category.randomSelection());
        }
    }
}
