package racinggame.service;

import racinggame.object.Car;
import racinggame.object.Round;

public interface View {
    int inputRoundCount();
    int inputCarCount();
    void output(Car[] cars);
}
