package pl.malek.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "bikes")
public class Bike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String bikeName;

    @NotNull
    private String frame;

    @NotNull
    private String fork;

    @NotNull
    private String wheels;

    @NotNull
    private String tires;

    @NotNull
    private String front_derailleur;

    @NotNull
    private String rear_derailleur;

    @NotNull
    private String brakes;

    @NotNull
    private String seat;

    @NotNull
    private String steering_wheel;

    @NotNull
    private String shifters;

    @NotNull
    private String pedals;

    private Double weight;

    private BigDecimal price;

    @ManyToMany
    @Transient
    private Part part;

    public Bike(@NotNull String bikeName, @NotNull String frame, @NotNull String fork, @NotNull String wheels,
                @NotNull String tires, @NotNull String front_derailleur, @NotNull String rear_derailleur,
                @NotNull String brakes, @NotNull String seat, @NotNull String steering_wheel,
                @NotNull String shifters, @NotNull String pedals, Double weight, BigDecimal price, Part part) {
        this.bikeName = bikeName;
        this.frame = frame;
        this.fork = fork;
        this.wheels = wheels;
        this.tires = tires;
        this.front_derailleur = front_derailleur;
        this.rear_derailleur = rear_derailleur;
        this.brakes = brakes;
        this.seat = seat;
        this.steering_wheel = steering_wheel;
        this.shifters = shifters;
        this.pedals = pedals;
        this.weight = weight;
        this.price = price;
        this.part = part;
    }

    public Bike() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBikeName() {
        return bikeName;
    }

    public void setBikeName(String bikeName) {
        this.bikeName = bikeName;
    }

    public String getFrame() {
        return frame;
    }

    public void setFrame(String frame) {
        this.frame = frame;
    }

    public String getFork() {
        return fork;
    }

    public void setFork(String fork) {
        this.fork = fork;
    }

    public String getWheels() {
        return wheels;
    }

    public void setWheels(String wheels) {
        this.wheels = wheels;
    }

    public String getTires() {
        return tires;
    }

    public void setTires(String tires) {
        this.tires = tires;
    }

    public String getFront_derailleur() {
        return front_derailleur;
    }

    public void setFront_derailleur(String front_derailleur) {
        this.front_derailleur = front_derailleur;
    }

    public String getRear_derailleur() {
        return rear_derailleur;
    }

    public void setRear_derailleur(String rear_derailleur) {
        this.rear_derailleur = rear_derailleur;
    }

    public String getBrakes() {
        return brakes;
    }

    public void setBrakes(String brakes) {
        this.brakes = brakes;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public String getSteering_wheel() {
        return steering_wheel;
    }

    public void setSteering_wheel(String steering_wheel) {
        this.steering_wheel = steering_wheel;
    }

    public String getShifters() {
        return shifters;
    }

    public void setShifters(String shifters) {
        this.shifters = shifters;
    }

    public String getPedals() {
        return pedals;
    }

    public void setPedals(String pedals) {
        this.pedals = pedals;
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
