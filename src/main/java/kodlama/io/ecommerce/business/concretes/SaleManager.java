package kodlama.io.ecommerce.business.concretes;

import kodlama.io.ecommerce.business.abstracts.ProductService;
import kodlama.io.ecommerce.business.abstracts.SaleService;
import kodlama.io.ecommerce.business.dto.requests.ProductSaleRequest;
import kodlama.io.ecommerce.business.dto.requests.create.CreateProductRequest;
import kodlama.io.ecommerce.business.dto.requests.create.CreateSaleRequest;
import kodlama.io.ecommerce.business.dto.requests.update.UpdateProductRequest;
import kodlama.io.ecommerce.business.dto.requests.update.UpdateSaleRequest;
import kodlama.io.ecommerce.business.dto.responses.create.CreateProductResponse;
import kodlama.io.ecommerce.business.dto.responses.create.CreateSaleResponse;
import kodlama.io.ecommerce.business.dto.responses.get.*;
import kodlama.io.ecommerce.business.dto.responses.update.UpdateProductResponse;
import kodlama.io.ecommerce.business.dto.responses.update.UpdateSaleResponse;
import kodlama.io.ecommerce.business.rules.SaleBusinessRules;
import kodlama.io.ecommerce.entities.Category;
import kodlama.io.ecommerce.entities.Product;
import kodlama.io.ecommerce.entities.Sale;
import kodlama.io.ecommerce.repository.SaleRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class SaleManager implements SaleService {
    private final SaleRepository repository;
    private final ModelMapper mapper;
    private final SaleBusinessRules rules;
    private final ProductService productService;
    @Override
    public List<GetAllSalesResponse> getAll() {
        List<Sale> sales = repository.findAll();
        List<GetAllSalesResponse> response = sales
                .stream()
                .map(sale -> mapper.map(sale, GetAllSalesResponse.class))
                .toList();

        return  response;
    }

    @Override
    public GetSaleResponse getById(UUID id) {
        var sale = repository.findById(id).orElseThrow();
        GetSaleResponse response = mapper.map(sale, GetSaleResponse.class);
        return response;

    }

    @Override
    public CreateSaleResponse add(CreateSaleRequest request) {
        //checkAvailabilityOfTheProduct(request.getSoldProducts().get());
        var sale = mapper.map(request,Sale.class);
        sale.setId(UUID.randomUUID());
        sale.setSaleDate(LocalDateTime.now());
        // TODO: add products
        repository.save(sale);
        CreateSaleResponse response = mapper.map(sale, CreateSaleResponse.class);
        return response;
    }

    @Override
    public UpdateSaleResponse update(UUID id, UpdateSaleRequest request) {
        var sale = mapper.map(request, Sale.class);
        sale.setId(id);
        repository.save(sale);
        var response = mapper.map(sale,UpdateSaleResponse.class);
        return response;
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);

    }

    public void checkAvailabilityOfTheProduct(UUID id){
        rules.checkProductStateIsActive(id);
        rules.isProductOutOfStock(id);
    }

}
