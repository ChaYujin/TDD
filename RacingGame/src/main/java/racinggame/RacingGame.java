package racinggame;

import racinggame.object.Car;
import racinggame.object.RacingCar;
import racinggame.object.Round;
import racinggame.service.Processor;
import racinggame.service.RacingGameProcessor;
import racinggame.service.RacingGameView;
import racinggame.service.View;

public class RacingGame implements Game{
    Processor processor = new RacingGameProcessor();
    View view = new RacingGameView();

    @Override
    public void start() {
        int car_count = view.inputCarCount();
        int round_count = view.inputRoundCount();
        processor.start( car_count , round_count );
    }
}