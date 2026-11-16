package exercise4;

import java.util.Locale;

public class Test {
    public static void main(String[] args) {
        StringManipulator toUpperCase = String::toUpperCase;
        StringManipulator reverse = s->(new StringBuilder(s)).reverse().toString();

        System.out.println(applyManip(toUpperCase,"this text should be in upper case"));
        System.out.println(applyManip(reverse,"yllamron txet siht daer dluohs uoy"));
    }

    public static String applyManip(StringManipulator manip,String s){
        return  manip.manipulate(s);


    }
}
