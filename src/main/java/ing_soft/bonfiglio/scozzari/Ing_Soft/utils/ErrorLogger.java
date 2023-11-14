package ing_soft.bonfiglio.scozzari.Ing_Soft.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

@Data
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class ErrorLogger<T> {

    private final Logger logger;

    public ErrorLogger(Class<T> clazz) {
        this.logger = Logger.getLogger(clazz.getName());

        // Create a console handler and set its level
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.ALL);

        // Add the console handler to the logger
        logger.addHandler(consoleHandler);

        // Set the logger's level
        logger.setLevel(Level.ALL);
    }

    public void logError(String message, Throwable throwable) {
        logger.log(Level.SEVERE, message, throwable);
    }

    public void logError(String message) {
        logger.log(Level.SEVERE, message);
    }

}
