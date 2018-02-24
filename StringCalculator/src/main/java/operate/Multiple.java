package operate;

public class Multiple extends Operator {

    public Multiple( int num1, int num2){
        super(num1, num2);
    }

    @Override
    public int operate() {
        return num1 * num2;
    }
}
