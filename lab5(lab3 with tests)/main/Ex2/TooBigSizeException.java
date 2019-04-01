package Ex2;

public class TooBigSizeException extends Exception {
    public TooBigSizeException() {
        System.out.println("Too many arguments");
    }
}
