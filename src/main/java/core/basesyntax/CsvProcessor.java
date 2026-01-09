package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class CsvProcessor {
    private final OperationStrategy strategy;

    public CsvProcessor(OperationStrategy strategy) {
        this.strategy = strategy;
    }

    public void process(List<String> lines) {
        for (String line : lines) {
            if (line.startsWith("type")) {
                continue;
            }

            String[] parts = line.split(",");
            if (parts.length != 3) {
                throw new RuntimeException("Invalid line: " + line);
            }

            Storage.Operation operation =
                    Storage.Operation.fromCode(parts[0]);

            int quantity = Integer.parseInt(parts[2]);
            strategy.get(operation).apply(parts[1], quantity);
        }
    }
}
