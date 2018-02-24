package operate;

public abstract class Operator {
    int num1, num2;

    Operator( int num1, int num2 ){
        this.num1 = num1;
        this.num2 = num2;
    }

    public abstract int operate();

}
