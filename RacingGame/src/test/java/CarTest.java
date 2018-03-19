import static org.assertj.core.api.Assertions.*;
import org.junit.Before;
import org.junit.Test;
import racinggame.object.RacingCar;
import racinggame.service.RacingGameView;

public class CarTest {
    private RacingCar car;

    @Before
    public void setup(){
        car = new RacingCar(1);
    }

    @Test
    public void 자동차앞으로가기(){
        car.go();
        assertThat(car.go()).isEqualTo(2);
    }
}
