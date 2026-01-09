package core.basesyntax.handler;

import core.basesyntax.Storage;

public class PurchaseOperation implements OperationHandler {
    private final Storage storage;

    public PurchaseOperation(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void apply(String fruit, int quantity) {
        storage.getFruits()
                .put(fruit, storage.getFruits()
                        .getOrDefault(fruit, 0) - quantity);
    }
}
