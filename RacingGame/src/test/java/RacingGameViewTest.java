import static org.assertj.core.api.Assertions.*;
import org.junit.Before;
import org.junit.Test;
import racinggame.service.RacingGameView;

public class RacingGameViewTest {
    private RacingGameView view;
    @Before
    public void setup(){
        view = new RacingGameView();
    }

    @Test
    public void 라운드수입력(){
        int count = view.inputRoundCount();
        assertThat(count).isEqualTo(5);
    }

    @Test
    public void 자동차수입력(){
        int count = view.inputCarCount();
        assertThat(count).isEqualTo(5);
    }
}
