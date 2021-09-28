package br.com.product.catalog.services;

import br.com.product.catalog.dto.request.ProductRequest;
import br.com.product.catalog.dto.response.ProductResponse;
import br.com.product.catalog.helper.ProductHelper;
import br.com.product.catalog.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductHelper helper;

    public ProductService(ProductRepository productRepository,
                          ProductHelper helper) {
        this.productRepository = productRepository;
        this.helper = helper;
    }

    public ProductResponse getProduct(Long productId) {
        return helper.toResponse(productRepository.findById(productId).get());
    }

    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll().stream().map(helper::toResponse).collect(Collectors.toList());
    }

    public ProductResponse saveNew(ProductRequest request) {
        return helper.toResponse(productRepository.save(helper.toDomain(request)));
    }

    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }
}
