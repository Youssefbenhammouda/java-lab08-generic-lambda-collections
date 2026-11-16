package exercise4;
@FunctionalInterface
public interface StringManipulator {
    // Single abstract method that takes
    // a String and returns a modified String
    String manipulate(String input);
}
