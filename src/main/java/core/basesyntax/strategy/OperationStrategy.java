package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.service.OperationHandler;

public interface OperationStrategy {
    OperationHandler get(Storage.Operation operation);
}
