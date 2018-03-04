package stringCalculator;

public interface StringCalculator {
    void setEquation( String equation );
    void calculate() throws Exception;
    int getResult();
}
