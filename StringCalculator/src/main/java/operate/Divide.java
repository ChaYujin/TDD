package operate;

public class Divide extends Operator {

    public Divide( int num1 , int num2 ){
        super( num1 , num2 );
    }

    @Override
    public int operate() {
        return num1 / num2;
    }
}
