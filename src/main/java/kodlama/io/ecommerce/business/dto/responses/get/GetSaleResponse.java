package kodlama.io.ecommerce.business.dto.responses.get;

import kodlama.io.ecommerce.business.dto.responses.get.GetAllProductsResponse;
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
public class GetSaleResponse {
    private UUID id;
    private double price;
    private LocalDateTime saleDate;
    List<GetAllProductsResponse> products;
}
