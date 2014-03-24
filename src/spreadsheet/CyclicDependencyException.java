package spreadsheet;

public class CyclicDependencyException extends Exception {

    private static final long serialVersionUID = 1L;

    public CyclicDependencyException(String msg) {
        super(msg);
    }
}
