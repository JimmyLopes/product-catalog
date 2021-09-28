package br.com.product.catalog.helper;

import br.com.product.catalog.dto.request.ProductRequest;
import br.com.product.catalog.dto.response.ProductResponse;
import br.com.product.catalog.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductHelper {

    public Product toDomain(ProductRequest request) {
        return new Product()
                .setName(request.getName())
                .setDescription(request.getDescription())
                .setBrand(request.getBrand())
                .setPrice(request.getPrice());
    }

    public ProductResponse toResponse(Product domain) {
        return (ProductResponse) new ProductResponse()
                .setName(domain.getName())
                .setDescription(domain.getDescription())
                .setBrand(domain.getBrand())
                .setPrice(domain.getPrice());
    }

}
