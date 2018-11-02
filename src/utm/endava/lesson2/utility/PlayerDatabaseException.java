package utm.endava.lesson2.utility;

public class PlayerDatabaseException extends Exception{
    
    public PlayerDatabaseException(String message) {
        super(message);
    }
    
    public PlayerDatabaseException() {
        super("Not enough players in the database for the teams requested!");
    }
}
