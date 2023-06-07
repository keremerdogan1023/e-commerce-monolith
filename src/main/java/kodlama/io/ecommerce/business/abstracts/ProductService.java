package kodlama.io.ecommerce.business.abstracts;

import kodlama.io.ecommerce.business.dto.requests.create.CreateProductRequest;
import kodlama.io.ecommerce.business.dto.requests.update.UpdateProductRequest;
import kodlama.io.ecommerce.business.dto.responses.create.CreateProductResponse;
import kodlama.io.ecommerce.business.dto.responses.get.GetAllProductsResponse;
import kodlama.io.ecommerce.business.dto.responses.get.GetProductResponse;
import kodlama.io.ecommerce.business.dto.responses.update.UpdateProductResponse;
import kodlama.io.ecommerce.entities.Product;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    List<GetAllProductsResponse> getAll(boolean IsActive);
    GetProductResponse getById(UUID id);
    CreateProductResponse add(CreateProductRequest request);
    UpdateProductResponse update(UUID id, UpdateProductRequest request);
    void delete(UUID id);
}
