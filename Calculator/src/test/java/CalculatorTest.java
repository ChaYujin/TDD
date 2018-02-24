import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {

    Calculator calculator;

    @Before
    public void setup() {
        System.out.println("before");
        calculator = new Calculator();
    }

    @Test
    public void sum() {
        System.out.println("sum");
        assertThat(calculator.sum(2,4)).isEqualTo(6);
    }

    @Test
    public void minus() {
        System.out.println("minus");
        assertThat(calculator.minus(4,2)).isEqualTo(2);
    }

    @After
    public void after() {
        System.out.println("after");
    }
    @Test
    public void multiply() {

    }

    @Test
    public void divide() {

    }


}
