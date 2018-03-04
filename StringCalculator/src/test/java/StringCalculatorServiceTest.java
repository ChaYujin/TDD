import calculator.Calculator;
import calculator.SimpleCalculator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import stringCalculator.StringCalculator;
import stringCalculator.StringCalculatorService;
import util.CommonUtils;

import java.util.ArrayList;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class StringCalculatorServiceTest {
    private StringCalculatorService stringCalculator;
    private Map<String,Calculator> operatorMap;

    @Before
    public void setUp(){
        StringCalculator stringCalculator = StringCalculatorService.getInstance();
        operatorMap = SimpleCalculator.getOperatorMap();
    }

    @Test
    public void getSplitStringWithStringCalculatorConjunction(){
        String test_str = "2 - 3 + 5";
        ArrayList<String> test_list = new ArrayList<>();
        test_list.add("2");
        test_list.add("-");
        test_list.add("3");
        test_list.add("+");
        test_list.add("5");
        assertThat(CommonUtils.splitStringWithInputValue( test_str ," ")).hasSameElementsAs(test_list);
    }

    @Test
    public void calculateWithOperateStringArray(){

        String[] str_arr = new String[]{"1","-","4","*","2"};
        String operator = "";
        int result = Integer.parseInt(str_arr[0]);

        for( int i=1; i<str_arr.length ; i++ ){
            if( i%2 == 1 ){
                operator = str_arr[i];
                continue;
            }
            result = operatorMap.get(operator).calculate( result , Integer.parseInt(str_arr[i]) );
        }
        assertThat(result).isEqualTo(-6);
    }
}
