package pl.malek.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
@Table(name = "parts")
public class Part {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 2, max = 255)
    private String name;

    @NotNull
    private Double weight;

   @ManyToOne
   @NotNull
   private Category category;

    @NotNull
    private String producer;

    @NotNull
    private BigDecimal price;

    public Part() {
    }

    public Part(@NotNull @Size(min = 2, max = 255) String name, @NotNull Double weight, @NotNull Category category, @NotNull String producer,
                @NotNull BigDecimal price) {
        this.name = name;
        this.weight = weight;
        this.category = category;
        this.producer = producer;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Part{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", category=" + category +
                ", producer='" + producer + '\'' +
                ", price=" + price +
                '}';
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
