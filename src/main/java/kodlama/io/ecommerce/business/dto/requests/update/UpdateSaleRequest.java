package kodlama.io.ecommerce.business.dto.requests.update;

import kodlama.io.ecommerce.business.dto.requests.ProductSaleRequest;
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
public class UpdateSaleRequest {
    private UUID id;
    private double price;
    private LocalDateTime saleDate;
    List<ProductSaleRequest> products;
}
