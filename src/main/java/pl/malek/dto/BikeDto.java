package pl.malek.dto;


import pl.malek.model.Frame;
import pl.malek.model.Wheel;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;


public class BikeDto {

    private Long id;

    @NotNull
    private String name;

    @NotNull
    private Frame frame;

    @NotNull
    private Wheel wheel;

    @NotNull
    private Double weight;

    @NotNull
    private BigDecimal price;


    public BikeDto() {
    }

    public BikeDto(@NotNull String name, @NotNull Frame frame, @NotNull Wheel wheel, @NotNull Double weight, @NotNull BigDecimal price) {
        this.name = name;
        this.frame = frame;
        this.wheel = wheel;
        this.weight = weight;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Frame getFrame() {
        return frame;
    }

    public void setFrame(Frame frame) {
        this.frame = frame;
    }

    public Wheel getWheel() {
        return wheel;
    }

    public void setWheel(Wheel wheel) {
        this.wheel = wheel;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
