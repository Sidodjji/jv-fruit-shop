package core.basesyntax.report;

import core.basesyntax.Storage;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String HEADER = "fruit,quantity";
    private static final String SEPARATOR = ",";
    private static final String NEW_LINE = System.lineSeparator();

    private final Storage storage;

    public ReportGeneratorImpl(Storage storage) {
        this.storage = storage;
    }

    @Override
    public String getReport() {
        StringBuilder report = new StringBuilder();
        report.append(HEADER).append(NEW_LINE);
        report.append(buildBody());
        return report.toString();
    }

    private String buildBody() {
        StringBuilder body = new StringBuilder();

        for (Map.Entry<String, Integer> entry
                : storage.getFruits().entrySet()) {

            body.append(entry.getKey())
                    .append(SEPARATOR)
                    .append(entry.getValue())
                    .append(NEW_LINE);
        }
        return body.toString();
    }
}
