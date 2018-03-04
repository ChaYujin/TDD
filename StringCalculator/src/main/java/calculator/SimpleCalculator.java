package calculator;

import java.util.HashMap;
import java.util.Map;

public enum SimpleCalculator implements Calculator{
    ADD("+") {
        @Override
        public int calculate(int num1, int num2){ return num1+num2; }
    },
    MINUS("-") {
        @Override
        public int calculate(int num1, int num2){ return num1-num2; }
    },
    MULTIPLE("*") {
        @Override
        public int calculate(int num1, int num2){ return num1*num2; }
    },
    DIVIDE("/") {
        @Override
        public int calculate(int num1, int num2){ return num1/num2; }
    };

    private String operator;
    private SimpleCalculator( String operator ){
        this.operator = operator;
    }

    private static Map<String, Calculator> operatorMapping;

    public static Map getOperatorMap(){
        if( operatorMapping == null ){
            operatorMapping = new HashMap<>();
            for( SimpleCalculator calculator : SimpleCalculator.values() ){
                operatorMapping.put( calculator.operator , calculator );
            }
        }
        return operatorMapping;
    }
}
