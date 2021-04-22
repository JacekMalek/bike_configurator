package pl.malek.dto;


import pl.malek.model.Frame;
import pl.malek.model.Wheel;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;


public class BikeDto {

    private Long id;

    @NotNull
    private String name;


    private Frame frame;


    private Wheel wheel;


    private Double weight;


    private BigDecimal price;


    public BikeDto() {
    }

    public BikeDto(Long id, @NotNull String name, Double weight, BigDecimal price) {
        this.id = id;
        this.name = name;
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
