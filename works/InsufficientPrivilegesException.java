package works;

public class InsufficientPrivilegesException extends RuntimeException{
	public InsufficientPrivilegesException() {
		super("No se poseen privilegios de empleado");
	}
}
