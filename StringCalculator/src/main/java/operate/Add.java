package operate;

public class Add extends Operator {

    public Add( int num1 , int num2 ){
        super( num1, num2 );
    }

    @Override
    public int operate() {
        return num1 + num2;
    }
}
