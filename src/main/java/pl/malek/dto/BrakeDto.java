package pl.malek.dto;

import pl.malek.model.Bike;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class BrakeDto {


    private Long id;

    @NotNull
    @Size(min = 2, max = 200)
    private String name;

    @NotNull
    private String type;

    @NotNull
    private String producer;

    @NotNull
    private BigDecimal price;

    @NotNull
    private Double weight;


    public BrakeDto() {
    }

    public BrakeDto(Long id, String name, String type, String producer, BigDecimal price, Double weight) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.producer = producer;
        this.price = price;
        this.weight = weight;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

}
