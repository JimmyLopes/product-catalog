package br.com.product.catalog.resources;

import br.com.product.catalog.dto.request.ProductRequest;
import br.com.product.catalog.dto.response.ProductResponse;
import br.com.product.catalog.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductResource {

    private final ProductService productService;

    public ProductResource(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{productId}")
    public ProductResponse getProduct(@PathVariable Long productId) {
        return productService.getProduct(productId);
    }

    @GetMapping
    public List<ProductResponse> getall() {
        return productService.getAllProducts();
    }

    @PostMapping
    public ProductResponse saveNew(@RequestBody ProductRequest request) {
        return productService.saveNew(request);
    }

    @DeleteMapping("/{productId}")
    public void deleteAll(@PathVariable Long productId) {
        productService.deleteProduct(productId);
    }
}