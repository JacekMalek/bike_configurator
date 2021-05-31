package pl.malek.calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.malek.model.Brake;
import pl.malek.model.Frame;
import pl.malek.model.Wheel;

import static org.junit.jupiter.api.Assertions.*;

class WeightCalculatorTest {

    @Test
    void shouldCalculateWeight() {
        //given
        Frame frame = new Frame();
        frame.setWeight(10.0);
        Wheel wheel = new Wheel();
        wheel.setWeight(5.0);
        Brake brake = new Brake();
        brake.setWeight(3.5);
        WeightCalculator weightCalculator = new WeightCalculator();

        //when
        Double result = weightCalculator.calculateWeight(frame, wheel, brake);

        //then
        Assertions.assertThat(result).isEqualTo(18.5);

    }

}