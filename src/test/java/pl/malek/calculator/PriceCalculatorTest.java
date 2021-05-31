package pl.malek.calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.malek.model.Brake;
import pl.malek.model.Frame;
import pl.malek.model.Wheel;
import java.math.BigDecimal;


class PriceCalculatorTest {

    @Test
    void shouldCalculatePrice() {
        //given
        Frame frame = new Frame();
        frame.setPrice(BigDecimal.valueOf(1000));
        Wheel wheel = new Wheel();
        wheel.setPrice(BigDecimal.valueOf(500));
        Brake brake = new Brake();
        brake.setPrice(BigDecimal.valueOf(400));
        PriceCalculator priceCalculator = new PriceCalculator();

        //when
        BigDecimal result = priceCalculator.calculatePrice(frame, wheel, brake);

        //then
        Assertions.assertThat(result).isEqualTo(new BigDecimal(1900));

    }
}