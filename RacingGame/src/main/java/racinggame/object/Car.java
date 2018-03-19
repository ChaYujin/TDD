package racinggame.object;

public interface Car {
    int go();
    boolean isCanGo();
    Round[] getRounds();
    void goRound();
    int getCurrentDistance();
}
