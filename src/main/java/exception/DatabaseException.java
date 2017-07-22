package exception;

/**
 *
 * @author Dries
 */
public class DatabaseException extends Exception {
    
    public DatabaseException(String message){
        super(message);
    }
    
    public DatabaseException(String message, Throwable throwable){
        super(message,throwable);
    }
}
