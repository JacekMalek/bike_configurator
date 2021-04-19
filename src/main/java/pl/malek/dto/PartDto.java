package pl.malek.dto;

import pl.malek.model.Category;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class PartDto {

    private Long id;

    @NotNull
    @Size(min = 2, max = 255)
    private String name;

    @NotNull
    private Double weight;

    @ManyToOne(fetch = FetchType.EAGER)
    @NotNull
    private Category category;

    @NotNull
    private String producer;

    @NotNull
    private BigDecimal price;


    public PartDto(@NotNull @Size(min = 2, max = 255) String name, @NotNull Double weight, @NotNull Category category,
                   @NotNull String producer, @NotNull BigDecimal price) {
        this.name = name;
        this.weight = weight;
        this.category = category;
        this.producer = producer;
        this.price = price;
    }

    public PartDto() {
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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
}
