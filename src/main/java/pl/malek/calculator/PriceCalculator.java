package pl.malek.calculator;

import org.springframework.stereotype.Component;
import pl.malek.model.Brake;
import pl.malek.model.Frame;
import pl.malek.model.Wheel;

import java.math.BigDecimal;

@Component
public class PriceCalculator {

    public static BigDecimal calculatePrice(Frame frame, Wheel wheel, Brake brake) {
        BigDecimal framePrice = frame.getPrice();
        BigDecimal wheelPrice = wheel.getPrice();
        BigDecimal brakePrice = brake.getPrice();
        return framePrice.add(wheelPrice).add(brakePrice);
    }
}
