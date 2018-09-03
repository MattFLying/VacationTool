package web.exception;

/**
 * Exception which is used when required value has null value.
 * 
 * @author Mateusz Mucha
 *
 */
public class ValueCannotBeNull extends Exception {
	private static final long serialVersionUID = 8154158775542303226L;

	public ValueCannotBeNull(String message) {
		super(message);
	}

}
