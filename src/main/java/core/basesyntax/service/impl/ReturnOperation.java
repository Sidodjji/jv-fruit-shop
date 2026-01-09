package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.OperationHandler;

public class ReturnOperation implements OperationHandler {
    private final Storage storage;

    public ReturnOperation(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void apply(String fruit, int quantity) {
        if (quantity < 0) {
            throw new RuntimeException("Return quantity cannot be negative");
        }
        storage.getFruits().put(
                fruit,
                storage.getFruits().getOrDefault(fruit, 0) + quantity
        );
    }
}
