package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.OperationHandler;

public class BalanceOperation implements OperationHandler {
    private final Storage storage;

    public BalanceOperation(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void apply(String fruit, int quantity) {
        if (quantity < 0) {
            throw new RuntimeException("Balance cannot be negative");
        }
        storage.getFruits().put(fruit, quantity);
    }
}
