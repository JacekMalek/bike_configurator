package pl.malek.dto;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class WheelDto {

    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String size;

    @NotNull
    private Double weight;

    @NotNull
    private BigDecimal price;

    public WheelDto() {
    }

    public WheelDto(Long id, @NotNull String name, @NotNull String size, @NotNull Double weight, @NotNull BigDecimal price) {
        this.id = id;
        this.name = name;
        this.size = size;
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
