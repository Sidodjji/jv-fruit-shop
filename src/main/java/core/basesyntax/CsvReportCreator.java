package core.basesyntax;

import core.basesyntax.strategy.OperationStrategy;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CsvReportCreator {
    public CsvReportCreator(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    private OperationStrategy operationStrategy;

    public File processCsv(File inputFile, File outputFile) {

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {

            String line;
            while ((line = reader.readLine()) != null) {

                if (line.startsWith("type")) {
                    continue;
                }

                String[] parts = line.split(",");

                Storage.Operation operation =
                        Storage.Operation.fromCode(parts[0]);

                operationStrategy
                        .get(operation)
                        .apply(parts[1], Integer.parseInt(parts[2]));
            }

        } catch (IOException e) {
            throw new RuntimeException("Ошибка обработки CSV", e);
        }

        return outputFile;
    }

}
