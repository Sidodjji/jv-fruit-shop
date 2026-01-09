package core.basesyntax.strategy;

import core.basesyntax.Storage;
import core.basesyntax.handler.OperationHandler;

public interface OperationStrategy {
    OperationHandler get(Storage.Operation operation);
}
