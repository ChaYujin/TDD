package racinggame.service;

import racinggame.object.Car;
import racinggame.object.Round;

import java.util.Scanner;

public class RacingGameView implements  View{
    private Scanner scanner = new Scanner(System.in);

    @Override
    public int inputRoundCount() throws NumberFormatException {
        System.out.print("라운드 갯수를 입력해주세요. \n입력 : ");
        return scanner.nextInt();
    }

    @Override
    public int inputCarCount() throws NumberFormatException {
        System.out.print("레이싱카 갯수를 입력해주세요. \n입력 : ");
        return scanner.nextInt();
    }

    @Override
    public void output(Car[] cars) {
        if( cars == null || cars.length == 0 ){
            System.out.println("(output) Error! There is no cars");
            return;
        }

        Car aCar = cars[0];

        if( aCar.getRounds() == null || aCar.getRounds().length == 0 ){
            System.out.println("(output) Error! There is no rounds");
            return;
        }

        int round_count = aCar.getRounds().length;
        for( int i=0; i<round_count; i++ ){
            System.out.println("round #"+(i+1));
            printCarDistanceOfSpecificRound( i , cars );
        }
    }
    private void printCarDistanceOfSpecificRound( int round_number , Car[] cars ){
        int distance;
        for( int i=0; i<cars.length; i++ ){
            System.out.print("car"+(i+1)+" : ");
            distance = cars[i].getRounds()[round_number].getResult();
            printDistance( distance );
            System.out.println();
        }
    }
    private void printDistance( int distance ){
        for( int i=0; i<distance ; i++ ){
            System.out.print("-");
        }
    }
}
