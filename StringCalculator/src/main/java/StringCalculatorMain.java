
import stringCalculator.StringCalculator;
import stringCalculator.StringCalculatorService;
import util.CommonUtils;

public class StringCalculatorMain {
    public static void main( String[] args ){
        try {
            StringCalculator stringCalculator = StringCalculatorService.getInstance();
            String input_str = CommonUtils.readString( StringCalculatorService.getInputText() );
            stringCalculator.setEquation( input_str );
            stringCalculator.calculate();
            CommonUtils.print( StringCalculatorService.getOutputText( stringCalculator.getResult() ) );
        }catch (Exception e){
            System.out.println("ERROR : "+e.getMessage());
        }
    }
}
