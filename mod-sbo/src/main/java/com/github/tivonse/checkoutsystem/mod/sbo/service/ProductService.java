package com.github.tivonse.checkoutsystem.mod.sbo.service;

import com.github.tivonse.checkoutsystem.mod.sbo.model.Product;
import com.github.tivonse.checkoutsystem.mod.sbo.repository.ProductRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.UnavailableException;
import java.util.Optional;
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

    public Product updateById(Product in) throws NotFoundException {
        Product existingProduct = productRepository.findById(in.getId()).orElseGet(null);

        if (existingProduct == null)
            throw new NotFoundException("No such product is existed in database");

        existingProduct.setUnitPrice(in.getUnitPrice());
        existingProduct.setDescription(in.getDescription());

        // TODO ...
        return productRepository.save(existingProduct);

    }

    public void deleteById(String id) {
        productRepository.deleteById(UUID.fromString(id));
    }
}
