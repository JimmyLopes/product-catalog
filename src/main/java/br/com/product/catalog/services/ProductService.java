package br.com.product.catalog.services;

import br.com.product.catalog.dto.request.ProductRequest;
import br.com.product.catalog.helper.ProductHelper;
import br.com.product.catalog.model.Product;
import br.com.product.catalog.repository.ProductRepository;
import br.com.shopping.cart.commons.shopping.cart.commons.exception.ServiceException;
import org.springframework.stereotype.Service;

import java.util.List;

import static br.com.product.catalog.exception.ApplicationError.PCA_PRODUCT_NOT_FOUND;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductHelper helper;

    public ProductService(ProductRepository productRepository,
                          ProductHelper helper) {
        this.productRepository = productRepository;
        this.helper = helper;
    }

    public Product getProduct(Long productId) {
        return findProduct(productId);
    }

    private Product findProduct(Long productId) {
        return productRepository.findById(productId).orElseThrow(() -> new ServiceException(PCA_PRODUCT_NOT_FOUND, productId));
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product saveNew(ProductRequest request) {
        return productRepository.save(helper.toDomain(request));
    }

    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }
}
