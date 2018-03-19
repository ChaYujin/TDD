package racinggame.service;

import racinggame.object.Car;
import racinggame.object.GameRound;
import racinggame.object.RacingCar;
import racinggame.object.Round;

public class RacingGameProcessor implements Processor {
    private RacingGameView view = new RacingGameView();
    private Car[] cars;

    @Override
    public void start( int car_count , int round_count ) {
        cars = new Car[car_count];

        for( int i=0; i<cars.length; i++ ){
            cars[i] = new RacingCar( round_count );
            cars[i].goRound();
        }

        view.output( cars );
    }

}
