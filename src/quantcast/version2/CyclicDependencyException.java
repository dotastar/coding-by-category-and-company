package quantcast.version2;

public class CyclicDependencyException extends Exception {

    private static final long serialVersionUID = 1L;

    public CyclicDependencyException(String msg) {
        super(msg);
    }
}
