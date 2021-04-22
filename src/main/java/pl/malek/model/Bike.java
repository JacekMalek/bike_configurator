package pl.malek.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;


@Entity
@Table(name = "bikes")
public class Bike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 2, max = 50)
    private String name;


    @OneToOne(fetch = FetchType.EAGER)
    private Frame frame;



    @OneToOne(fetch = FetchType.EAGER)
    private Wheel wheel;

    private Double weight;

    private BigDecimal price;

    public Bike() {
    }

    public Bike(@NotNull String name, Frame frame, Wheel wheel, Double weight, BigDecimal price) {
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

    public void setWheel(Wheel wheels) {
        this.wheel = wheels;
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
