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

    @OneToOne // (fetch = FetchType.EAGER) Przy relacji OneToOne Eager jest domyślne więc nie trzeba stosować
    private Frame frame;

    @OneToOne // (fetch = FetchType.EAGER) Przy relacji OneToOne Eager jest domyślne więc nie trzeba stosować
    private Wheel wheel;

    @OneToOne
    private Brake brake;

    private Double weight;

    private BigDecimal price;

    public Bike() {
    }

    public Bike( String name, Frame frame, Wheel wheel, Brake brake, Double weight, BigDecimal price) {
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

    public void setWheel(Wheel wheels) {
        this.wheel = wheels;
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
