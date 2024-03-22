import java.util.ArrayList;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;   

public final class LoggerSingleton {

    ArrayList<String> loggedMessages;
    
    // Single instance
    private static LoggerSingleton instance = null;
    // Prevent instantiation from other classes by making constructor private
    private LoggerSingleton() {
        loggedMessages = new ArrayList<>();
    }

    // Method to get the single instance
    public static LoggerSingleton getInstance() {
        if (instance == null) instance = new LoggerSingleton();
        return instance;
    }

    private String getTime(){
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
    }

    // Method to demonstrate Singleton usage logging messages to the terminal
    public void logMessage(String message) {
        String loggedTime = getTime();
        loggedMessages.add(loggedTime + ": " + message);
        System.out.println("Logged Message: " + message + " at " + loggedTime);
    }

    public void getLog(){
        for (String message : loggedMessages){
            System.out.println(message);
        }
    }

}
