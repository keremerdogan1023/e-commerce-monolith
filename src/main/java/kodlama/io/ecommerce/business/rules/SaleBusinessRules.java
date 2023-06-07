package kodlama.io.ecommerce.business.rules;

import kodlama.io.ecommerce.business.abstracts.ProductService;
import kodlama.io.ecommerce.common.constants.Messages;
import kodlama.io.ecommerce.core.exceptions.BusinessException;
import kodlama.io.ecommerce.entities.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class SaleBusinessRules {
    private final ProductService productService;
    public void checkProductStateIsActive(UUID id){
        var product = productService.getById(id);
        if (product.getState().equals("Passive")){
            throw new BusinessException("Product is not available right now.");//TODO: Add this exception type to messages.
        }

    }
    public void isProductOutOfStock(UUID id){
        var product = productService.getById(id);
        if (product.getQuantity()<1){
            throw new BusinessException("Product is out of stock right now");
        }
    }
}
