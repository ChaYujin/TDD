package main;

import operate.*;

import java.util.Queue;
import java.util.Scanner;

public class StringCalculatorMain {
    public static void main( String[] args ){
        Scanner scan = new Scanner(System.in);
        System.out.print("계산할 문자열을 입력해주세요 (ex>11 + 5 * 2) : ");
        String input_string = scan.nextLine();
        String[] split_string = input_string.split(" ");

        if( ! isValidInput( split_string ) ){
            return;
        }

        String operator = "";
        int result=0;

        for( int i=0; i<split_string.length ; i++ ){
            if( i%2 == 1 ){
                operator = split_string[i];
                continue;
            }

            if( i == 0 ) {
                result = Integer.parseInt(split_string[i]);
                continue;
            }

            result = calculate( result , Integer.parseInt(split_string[i]) , operator );

        }

        System.out.println(input_string+" = "+result);
    }

    private static boolean isValidInput(String[] split_string) {
        return true;
    }

    private static int calculate( int num1, int num2, String operator_string ){
        Operator operator = null;
        int result = 0;

        if( "+".equals(operator_string) ){
            operator = new Add( num1 , num2 );
        }
        if( "-".equals(operator_string) ){
            operator = new Minus( num1 , num2 );
        }
        if( "*".equals(operator_string) ){
            operator = new Multiple( num1 , num2 );
        }
        if( "/".equals(operator_string) ){
            operator = new Divide( num1 , num2 );
        }

        if( operator != null ){
            result = operator.operate();
        }
        return result;
    }
}
