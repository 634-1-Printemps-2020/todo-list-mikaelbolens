package exception;

public class InvalidTacheException extends Throwable {
    public InvalidTacheException() {
        System.out.println("Tache inconnue");
    }
}
