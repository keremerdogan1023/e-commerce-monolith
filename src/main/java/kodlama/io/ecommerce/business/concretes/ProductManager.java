package kodlama.io.ecommerce.business.concretes;

import kodlama.io.ecommerce.business.abstracts.ProductService;
import kodlama.io.ecommerce.business.dto.requests.create.CreateProductRequest;
import kodlama.io.ecommerce.business.dto.requests.update.UpdateProductRequest;
import kodlama.io.ecommerce.business.dto.responses.create.CreateProductResponse;
import kodlama.io.ecommerce.business.dto.responses.get.GetAllProductsResponse;
import kodlama.io.ecommerce.business.dto.responses.get.GetProductResponse;
import kodlama.io.ecommerce.business.dto.responses.update.UpdateProductResponse;
import kodlama.io.ecommerce.business.rules.ProductBusinessRules;
import kodlama.io.ecommerce.entities.Product;
import kodlama.io.ecommerce.entities.enums.State;
import kodlama.io.ecommerce.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ProductManager implements ProductService {
    private final ProductRepository repository;
    private final ModelMapper mapper;
    private final ProductBusinessRules rules;

    @Override
    public List<GetAllProductsResponse> getAll(boolean IsActive) {
        List<Product> products = filterProductsByActiveState(IsActive);
        List<GetAllProductsResponse> response = products
                .stream()
                .map(product -> mapper.map(product, GetAllProductsResponse.class))
                .toList();

        return  response;
    }

    @Override
    public GetProductResponse getById(UUID id) {
        Product product = repository.findById(id).orElseThrow();
        GetProductResponse response = mapper.map(product,GetProductResponse.class);
        return response;
    }

    @Override
    public CreateProductResponse add(CreateProductRequest request) {
        Product product = mapper.map(request, Product.class);
        product.setId(UUID.randomUUID());
        product.setState(State.Active);
        repository.save(product);
        CreateProductResponse response = mapper.map(product, CreateProductResponse.class);
        return response;


    }

    @Override
    public UpdateProductResponse update(UUID id, UpdateProductRequest request) {
        rules.checkIfProductExists(id);
        Product product = mapper.map(request, Product.class);
        product.setId(id);
        repository.save(product);
        UpdateProductResponse response = mapper.map(product, UpdateProductResponse.class);
        return response;
    }

    @Override
    public void delete(UUID id) {
        rules.checkIfProductExists(id);
        repository.deleteById(id);
    }

    private List<Product> filterProductsByActiveState(boolean IsActive){
        if (IsActive){
            return repository.findAll();
        }
        return repository.findAllByStateIsNot(State.Active);
    }


}
