package pl.malek.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "wheels")
public class Wheel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotNull
    private String name;

    @NotNull
    private String size;

    @NotNull
    private Double weight;

    @NotNull
    private BigDecimal price;

    @OneToOne
    private Bike bike;


    public Wheel() {
    }

    public Wheel(Long id, @NotNull String name, @NotNull String size, @NotNull Double weight,
                 @NotNull BigDecimal price, Bike bike) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.weight = weight;
        this.price = price;
        this.bike = bike;
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

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
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
