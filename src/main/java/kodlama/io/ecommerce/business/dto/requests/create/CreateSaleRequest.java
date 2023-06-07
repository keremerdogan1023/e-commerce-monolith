package kodlama.io.ecommerce.business.dto.requests.create;

import kodlama.io.ecommerce.business.dto.requests.ProductSaleRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateSaleRequest {
    private double price;
    List<ProductSaleRequest> soldProducts;
}
