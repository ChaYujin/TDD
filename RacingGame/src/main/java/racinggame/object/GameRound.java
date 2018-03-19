package racinggame.object;

import racinggame.common.Utility;

import javax.rmi.CORBA.Util;

public class GameRound implements  Round{
    private int result=0;

    @Override
    public void start( Car car ) {
        this.result = car.getCurrentDistance();
        if( car.isCanGo() ){
            this.result = car.go();
        }
    }

    @Override
    public int getResult(){
        return result;
    }

}
