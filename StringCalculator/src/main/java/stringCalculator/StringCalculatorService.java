package stringCalculator;

import calculator.Calculator;
import calculator.SimpleCalculator;
import sun.java2d.pipe.SpanShapeRenderer;
import util.CommonUtils;

import java.util.Map;

public class StringCalculatorService implements StringCalculator {
    private static StringCalculator instance = new StringCalculatorService();
    private static String exampleText;
    private static String inputText;
    private static String prevOutputText;

    private StringCalculatorVO vo;
    private Map<String,Calculator> operatorMap;

    static{
        exampleText = "예) 1 + 2 * 3";
        inputText = "계산할 수식을 입력해주세요. "+exampleText+" \n입력 : ";
        prevOutputText = "결과 = ";
    }

    {
        operatorMap = SimpleCalculator.getOperatorMap();
    }

    private StringCalculatorService(){
    }

    public static StringCalculator getInstance(){
        return instance;
    }

    public static String getInputText(){
        return inputText;
    }

    public static String getOutputText( int result ){
        return prevOutputText+result;
    }

    @Override
    public void setEquation(String equation) {
        makeNewCalculatorVO();
        vo.setEquation( equation );
    }

    @Override
    public void calculate() throws Exception{
        int result = 0;
        String equation = getEquation();
        if( CommonUtils.isEmptyString(getEquation()) ){
            throw new Exception("수식을 먼저 설정해주세요.");
        }

        String[] operate_string_arr = getCalculatableStringArray( equation );
        result = calculateWithOperateStringArray( operate_string_arr );
        setResult( result );
    }

    @Override
    public int getResult(){
        if( vo == null ){
            return 0;
        }
        return vo.getResult();
    }

    private void makeNewCalculatorVO(){
        vo = new StringCalculatorVO();
    }

    private String getEquation(){
        if( vo == null ){
            return null;
        }
        return vo.getEquation();
    }

    private void setResult( int result ){
        if( vo == null ){
            makeNewCalculatorVO();
        }
        vo.setResult( result );
    }

    private int calculateWithOperateStringArray( String[] str_arr ){
        String operator = "";

        int result = Integer.parseInt(str_arr[0]);

        for( int i=1; i<str_arr.length ; i++ ){
            if( i%2 == 1 ){
                operator = str_arr[i];
                continue;
            }
            result = operatorMap.get(operator).calculate( result , Integer.parseInt(str_arr[i]) );
        }
        return result;
    }

    private String[] getCalculatableStringArray( String input_str ) throws Exception{
        String[] str_arr = getSplitStringWithStringCalculatorConjunction( input_str );

        if( isCalculatableStringArray( str_arr ) ){
            return str_arr;
        }

        throw new Exception("잘못된 수식이 입력되었습니다. 예와 같이 띄워쓰기를 포함하여 입력해주세요. "+exampleText );
    }

    private String[] getSplitStringWithStringCalculatorConjunction( String input_str ){
        return CommonUtils.splitStringWithInputValue( input_str ," ");
    }

    private static boolean isCalculatableStringArray( String[] split_string ) {
        return true;
    }
}
