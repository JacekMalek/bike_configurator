package pl.malek.calculator;

import org.springframework.stereotype.Component;
import pl.malek.model.Brake;
import pl.malek.model.Frame;
import pl.malek.model.Wheel;

@Component
public class WeightCalculator {

    public Double calculateWeight(Frame frame, Wheel wheel, Brake brake) {
        Double frameWeight = frame.getWeight();
        Double wheelWeight  = wheel.getWeight();
        Double brakeWeight  = brake.getWeight();
        return frameWeight + wheelWeight + brakeWeight;
    }
}