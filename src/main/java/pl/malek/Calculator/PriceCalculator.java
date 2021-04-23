package pl.malek.Calculator;

import org.springframework.stereotype.Component;
import pl.malek.model.Frame;
import pl.malek.model.Wheel;

import java.math.BigDecimal;

@Component
public class PriceCalculator {

    public static BigDecimal calculatePrice(Frame frame, Wheel wheel) {
        BigDecimal framePrice = frame.getPrice();
        BigDecimal wheelPrice = wheel.getPrice();
        return framePrice.add(wheelPrice);
    }
}
