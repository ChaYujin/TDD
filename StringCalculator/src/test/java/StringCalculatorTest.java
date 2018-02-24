import operate.Add;
import operate.Operator;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTest {
    @Test
    public void add(){
        Operator operator = new Add( 1, 3 );
        operator.operate();

        assertThat(operator.operate()).isEqualTo(4);
    }
}
