package util;

import java.util.Scanner;

public class CommonUtils {
    public static String[] splitStringWithInputValue(String inputStr, String conjunction ){
        return inputStr.split(conjunction);
    }

    public static String readString( String text ) {
        System.out.println(text);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static void print( String text ){
        System.out.print(text);
    }

    public static boolean isEmptyString( String str ){
        if( str == null || str.equals("") ){
            return true;
        }
        return false;
    }
}
