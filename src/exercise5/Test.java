package exercise5;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Function;

public class Test {

    private static final Random random = new Random();

    public static void main(String[] args) {

        String[] names = {"Anna", "bob", "CaroLine", "david", "Ed", "Fred", "gary"};

        List<Function<String, String>> functions = List.of(
                String::toUpperCase,
                s -> s + " " + getRandomChar('A', 'D') + ".",
                s -> s + " " + reverse(s, 0, s.indexOf(" ")),
                Test::reverse,
                String::new,
                s -> "Howdy " + s,
                "Mr. "::concat,
                ((Function<String, StringBuilder>) StringBuilder::new)
                        .andThen(StringBuilder::reverse)
                        .andThen(StringBuilder::toString),
                s -> s.replace(" ", "_"),
                String::toLowerCase,
                String::strip
        );

        applyChanges(names, functions);
    }

    public static void applyChanges(String[] names, List<Function<String, String>> functions) {
        List<String> backedByArray = Arrays.asList(names);
        for (Function<String, String> function : functions) {
            backedByArray.replaceAll(s -> s.transform(function));
            System.out.println(Arrays.toString(names));
        }
    }

    private static char getRandomChar(char startChar, char endChar) {
        return (char) random.nextInt(startChar, endChar + 1);
    }

    private static String reverse(String s) {
        return reverse(s, 0, s.length());
    }

    private static String reverse(String s, int start, int end) {
        return new StringBuilder(s.substring(start, end)).reverse().toString();
    }
}