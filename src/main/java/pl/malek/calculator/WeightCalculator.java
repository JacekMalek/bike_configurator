package pl.malek.calculator;

import org.springframework.stereotype.Component;
import pl.malek.model.Frame;
import pl.malek.model.Wheel;

@Component
public class WeightCalculator {

    public static Double calculateWeight(Frame frame, Wheel wheel) {
        Double frameWeight = frame.getWeight();
        Double wheelWeight  = wheel.getWeight();
        return (frameWeight + wheelWeight);
    }
}