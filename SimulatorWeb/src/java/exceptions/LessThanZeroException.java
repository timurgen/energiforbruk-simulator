/*
 * Throws in case if temperature inside unit less than zero (0)
 * 
 */
package exceptions;

/**
 *
 * @author 490501
 * @version 1.0.0
 * 
 */
public class LessThanZeroException extends Exception{
    
    public LessThanZeroException(String message) {
        super(message);
    }
    
}
