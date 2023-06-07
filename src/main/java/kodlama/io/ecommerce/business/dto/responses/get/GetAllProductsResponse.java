package kodlama.io.ecommerce.business.dto.responses.get;

import kodlama.io.ecommerce.entities.enums.State;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetAllProductsResponse {
    private UUID id;
    private String name;
    private int quantity;
    private double price;
    private String description;
    private State state;
}
