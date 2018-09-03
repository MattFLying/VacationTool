package web.exception;

/**
 * Exception which is used when wanted result could not be found and returned.
 * 
 * @author Mateusz Mucha
 *
 */
public class ResultNotFoundException extends Exception {
	private static final long serialVersionUID = 472409305340313528L;

	public ResultNotFoundException(String message) {
		super(message);
	}

}
