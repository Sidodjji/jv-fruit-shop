package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.impl.*;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Storage storage = new Storage();

        Map<Storage.Operation, OperationHandler> handlers = new HashMap<>();
        handlers.put(Storage.Operation.BALANCE, new BalanceOperation(storage));
        handlers.put(Storage.Operation.SUPPLY, new SupplyOperation(storage));
        handlers.put(Storage.Operation.PURCHASE, new PurchaseOperation(storage));
        handlers.put(Storage.Operation.RETURN, new ReturnOperation(storage));

        OperationStrategy strategy = new OperationStrategyImpl(handlers);

        FileReader fileReader = new FileReaderImpl();
        List<String> lines =
                fileReader.read("src/main/resources/reportToRead.csv");

        CsvProcessor processor = new CsvProcessor(strategy);
        processor.process(lines);

        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        String report = reportGenerator.getReport(storage.getFruits());

        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.write(report, "src/main/resources/finalReport.csv");
    }
}
