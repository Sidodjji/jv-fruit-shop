package core.basesyntax;

import core.basesyntax.handler.BalanceOperation;
import core.basesyntax.handler.OperationHandler;
import core.basesyntax.handler.PurchaseOperation;
import core.basesyntax.handler.ReturnOperation;
import core.basesyntax.handler.SupplyOperation;
import core.basesyntax.report.FileWriter;
import core.basesyntax.report.FileWriterImpl;
import core.basesyntax.report.ReportGenerator;
import core.basesyntax.report.ReportGeneratorImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.io.File;
import java.util.HashMap;
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

        CsvReportCreator csvReportCreator = new CsvReportCreator(strategy);
        csvReportCreator.processCsv(
                new File("reportToRead.csv"),
                new File("finalReport.csv")
        );

        ReportGenerator reportGenerator = new ReportGeneratorImpl(storage);
        String report = reportGenerator.getReport();

        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.write(report, "finalReport.csv");
    }
}
