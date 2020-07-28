package com.github.tivonse.checkoutsystem.mod.sbo.service;

import com.github.tivonse.checkoutsystem.mod.sbo.model.Product;
import com.github.tivonse.checkoutsystem.mod.sbo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public Product updateById(UUID id, Product existingProduct) {
        Product product = new Product();
        product.setUnitPrice(existingProduct.getUnitPrice());
        product.setDescription(existingProduct.getDescription());
        // TODO ...
        return productRepository.save(product);

    }

    public void deleteById(UUID id) {
        productRepository.deleteById(id);
    }
}
