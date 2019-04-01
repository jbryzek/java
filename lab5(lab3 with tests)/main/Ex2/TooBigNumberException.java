package Ex2;

public class TooBigNumberException extends Exception{
    public TooBigNumberException() {
        System.out.println("Too big number, it must be under 1 000 000");
}}
