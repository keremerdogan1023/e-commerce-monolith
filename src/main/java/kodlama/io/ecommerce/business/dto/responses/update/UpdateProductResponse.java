package kodlama.io.ecommerce.business.dto.responses.update;

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
public class UpdateProductResponse {
    private UUID id;
    private String name;
    private int quantity;
    private double price;
    private String description;
    private State state;

}
