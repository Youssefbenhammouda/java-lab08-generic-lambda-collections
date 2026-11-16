package exercise3;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class MiniChallenges {
    public static void main(String[] args) {
        // MiniChallenge 1
        Consumer<String> printTheParts = sentence -> {
            String[] parts = sentence.split(" ");
            for(String part:parts){
                System.out.println(part);
            }
        };


        printTheParts.accept("Hello World!");
        // MiniChallenge 3
        System.out.println(everySecondChar.apply("1234567890"));
        // MiniChallenge 5
        everySecondCharacter(everySecondChar,"1234567890");
        // MiniChallenge 6
        Supplier<String> iLoveJava = ()->"I love Java";
        // MiniChallenge 7
        String supplierResult =iLoveJava.get();
        System.out.println(supplierResult);
    }

    // MiniChallenge 4
    public static <T> void everySecondCharacter(Function<T,?> func, T param){

        System.out.println(func.apply(param));

    }

    // MiniChallenge 2
    static UnaryOperator<String> everySecondChar = source ->{
        StringBuilder returnVal = new StringBuilder();
        for (int i = 0; i < source.length(); i++) {
            if(i%2==1){
                returnVal.append(source.charAt(i));
            }
        }
        return returnVal.toString();
    };
}
