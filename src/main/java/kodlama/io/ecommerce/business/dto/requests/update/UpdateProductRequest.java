package kodlama.io.ecommerce.business.dto.requests.update;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateProductRequest {
    private int id;
    private String name;
    private int quantity;
    private double price;
    private String description;


}
