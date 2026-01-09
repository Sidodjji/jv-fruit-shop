package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.service.OperationHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<Storage.Operation, OperationHandler> handlers;

    public OperationStrategyImpl(
            Map<Storage.Operation, OperationHandler> handlers) {
        this.handlers = handlers;
    }

    @Override
    public OperationHandler get(Storage.Operation operation) {
        OperationHandler handler = handlers.get(operation);
        if (handler == null) {
            throw new RuntimeException(
                    "No handler for operation: " + operation);
        }
        return handler;
    }
}
