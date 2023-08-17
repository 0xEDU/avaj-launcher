package src.avaj_launcher.simulator;

import java.io.FileWriter;
import java.io.IOException;

public class Logger {
    private static Logger instance;
    private FileWriter fileWriter;

    private Logger() {
        try {
            fileWriter = new FileWriter("simulation.txt", true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public static void log(String message) {
        try {
            Logger logger = getInstance();
            logger.fileWriter.write(message + "\n");
            logger.fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void close() {
        try {
            Logger logger = getInstance();
            logger.fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
