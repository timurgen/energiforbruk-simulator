package exceptions;

/**
 *
 * @author 490501
 */
public class OversizedException extends Exception{

    public OversizedException(String square_of) {
        super(square_of);
    }

}
