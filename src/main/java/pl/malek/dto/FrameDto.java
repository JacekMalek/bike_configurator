package pl.malek.dto;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class FrameDto {


    private Long id;

    @NotNull
    @Size(min = 2, max = 200)
    private String name;

    @NotNull
    private String size;

    @NotNull
    private String material;

    @NotNull
    private Double weight;

    @NotNull
    @DecimalMin("0.01")
    private BigDecimal price;

    public FrameDto(Long id, @NotNull @Size(min = 2, max = 200) String name, @NotNull String size,
                    @NotNull String material, @NotNull Double weight, @NotNull @DecimalMin("0.01") BigDecimal price) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.material = material;
        this.weight = weight;
        this.price = price;
    }

    public FrameDto() {
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

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
}
