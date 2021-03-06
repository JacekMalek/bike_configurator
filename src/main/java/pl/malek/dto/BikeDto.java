package pl.malek.dto;


import pl.malek.model.Brake;
import pl.malek.model.Frame;
import pl.malek.model.Wheel;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;


public class BikeDto {

    private Long id;

    @NotNull
    @Size(min = 2, max = 200)
    private String name;

    @NotNull
    private Frame frame;

    @NotNull
    private Wheel wheel;

    @NotNull
    private Brake brake;

    private Double weight;

    private BigDecimal price;

    public BikeDto() {
    }



    public BikeDto(Long id, String name, Double weight, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    public BikeDto(Long id, String name, Frame frame, Wheel wheel, Brake brake, Double weight, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.frame = frame;
        this.wheel = wheel;
        this.brake= brake;
        this.weight = weight;
        this.price = price;
    }

    public BikeDto(String name, Frame frame, Wheel wheel, Brake brake, Double weight, BigDecimal price) {
        this.name = name;
        this.frame = frame;
        this.wheel = wheel;
        this.brake = brake;
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

    public Brake getBrake() {
        return brake;
    }

    public void setBrake(Brake brake) {
        this.brake = brake;
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
