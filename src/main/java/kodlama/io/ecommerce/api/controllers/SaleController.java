package kodlama.io.ecommerce.api.controllers;

import kodlama.io.ecommerce.business.abstracts.CategoryService;
import kodlama.io.ecommerce.business.abstracts.SaleService;
import kodlama.io.ecommerce.business.dto.requests.create.CreateCategoryRequest;
import kodlama.io.ecommerce.business.dto.requests.create.CreateSaleRequest;
import kodlama.io.ecommerce.business.dto.requests.update.UpdateCategoryRequest;
import kodlama.io.ecommerce.business.dto.requests.update.UpdateSaleRequest;
import kodlama.io.ecommerce.business.dto.responses.create.CreateCategoryResponse;
import kodlama.io.ecommerce.business.dto.responses.create.CreateSaleResponse;
import kodlama.io.ecommerce.business.dto.responses.get.GetAllCategoriesResponse;
import kodlama.io.ecommerce.business.dto.responses.get.GetAllSalesResponse;
import kodlama.io.ecommerce.business.dto.responses.get.GetCategoryResponse;
import kodlama.io.ecommerce.business.dto.responses.get.GetSaleResponse;
import kodlama.io.ecommerce.business.dto.responses.update.UpdateCategoryResponse;
import kodlama.io.ecommerce.business.dto.responses.update.UpdateSaleResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/api/sales")
public class SaleController {

    private final SaleService service;

    @GetMapping
    public List<GetAllSalesResponse> getAll(){
        return service.getAll();
    }
    @GetMapping("/{id}")
    public GetSaleResponse getById(@PathVariable UUID id){
        return service.getById(id);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateSaleResponse add(@RequestBody CreateSaleRequest request){
        return service.add(request);
    }
    @PutMapping("/{id}")
    public UpdateSaleResponse update(@PathVariable UUID id, @RequestBody UpdateSaleRequest request){
        return service.update(id,request);
    }
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id){
        service.delete(id);
    }
}
