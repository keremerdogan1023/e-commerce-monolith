package kodlama.io.ecommerce.entities;

import jakarta.persistence.*;
import kodlama.io.ecommerce.entities.enums.State;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sales")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private double price;
    private LocalDateTime saleDate;
    private State state;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
