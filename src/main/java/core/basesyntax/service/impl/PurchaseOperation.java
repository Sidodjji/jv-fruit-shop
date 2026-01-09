package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.OperationHandler;

public class PurchaseOperation implements OperationHandler {
    private final Storage storage;

    public PurchaseOperation(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void apply(String fruit, int quantity) {
        if (quantity < 0) {
            throw new RuntimeException("Purchase quantity cannot be negative");
        }

        int current = storage.getFruits().getOrDefault(fruit, 0);
        int result = current - quantity;

        if (result < 0) {
            throw new RuntimeException(
                    "Not enough " + fruit + " in storage");
        }
        storage.getFruits().put(fruit, result);
    }
}
