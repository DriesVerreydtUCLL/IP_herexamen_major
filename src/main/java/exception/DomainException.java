package exception;

/**
 *
 * @author Dries
 */
public class DomainException extends Exception {
    
    public DomainException(String message){
        super(message);
    }
    
    public DomainException(String message, Throwable throwable){
        super(message,throwable);
    }
}
