package main.java.ua.logic.util.logging;

import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class LightFormatter extends Formatter {
    @Override
    public String format(LogRecord record) {
        String message = formatMessage(record);

        return message + "\n";
    }
}
