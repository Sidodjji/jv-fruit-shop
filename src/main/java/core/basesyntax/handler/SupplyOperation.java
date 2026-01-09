package core.basesyntax.handler;

import core.basesyntax.Storage;

public class SupplyOperation implements OperationHandler {
    private final Storage storage;

    public SupplyOperation(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void apply(String fruit, int quantity) {
        storage.getFruits()
                .put(fruit, storage.getFruits()
                        .getOrDefault(fruit, 0) + quantity);
    }
}
