package racinggame.object;

import racinggame.common.Utility;

public class RacingCar implements Car {
    final private int acceleration = 1;
    private int distance = 1;

    Round[] rounds;

    public RacingCar( int round_count ){
        rounds = new GameRound[ round_count ];
        for( int i=0; i<rounds.length; i++ ){
            rounds[i] = new GameRound();
        }
    }

    @Override
    public int getCurrentDistance(){
        return this.distance;
    }

    @Override
    public int go(){
        this.distance += acceleration;
        return distance;
    }

    @Override
    public boolean isCanGo() {
        int num = Utility.random();
        return (num > 4);
    }

    @Override
    public Round[] getRounds(){
        return this.rounds;
    }

    @Override
    public void goRound(){
        for( Round round : rounds ){
            round.start( this );
        }
    }
}
