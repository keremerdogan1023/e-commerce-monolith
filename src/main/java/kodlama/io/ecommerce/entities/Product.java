package kodlama.io.ecommerce.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import kodlama.io.ecommerce.entities.enums.State;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    @Min(1)
    private int quantity;
    @Min(1)
    private double price;
    private String description;
    @Enumerated(EnumType.STRING)
    private State state;

    @ManyToMany
    @JoinTable(name = "product_category",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<Category> productCategories;
    @OneToMany(mappedBy = "product")
    private List<Sale> sales;

}
