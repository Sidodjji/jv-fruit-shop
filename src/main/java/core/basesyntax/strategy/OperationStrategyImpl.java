package core.basesyntax.strategy;

import core.basesyntax.Storage;
import core.basesyntax.handler.OperationHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<Storage.Operation, OperationHandler> operationHandlerMap;

    public OperationStrategyImpl(
            Map<Storage.Operation, OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public OperationHandler get(Storage.Operation operation) {
        return operationHandlerMap.get(operation);
    }
}
