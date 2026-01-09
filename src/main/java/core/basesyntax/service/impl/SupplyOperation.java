package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.OperationHandler;

public class SupplyOperation implements OperationHandler {
    private final Storage storage;

    public SupplyOperation(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void apply(String fruit, int quantity) {
        if (quantity < 0) {
            throw new RuntimeException("Supply quantity cannot be negative");
        }
        storage.getFruits().put(
                fruit,
                storage.getFruits().getOrDefault(fruit, 0) + quantity
        );
    }
}
