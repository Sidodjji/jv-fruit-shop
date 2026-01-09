package core.basesyntax;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private final Map<String, Integer> fruits = new HashMap<>();

    public Map<String, Integer> getFruits() {
        return fruits;
    }

    public enum Operation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        public static Operation fromCode(String code) {
            for (Operation op : values()) {
                if (op.code.equals(code)) {
                    return op;
                }
            }
            throw new IllegalArgumentException("Unknown operation: " + code);
        }

        Operation(String code) {
            this.code = code;
        }

        private final String code;

        public String getCode() {
            return code;
        }
    }
}
