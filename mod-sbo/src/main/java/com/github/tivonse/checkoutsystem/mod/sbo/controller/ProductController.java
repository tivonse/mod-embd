package com.github.tivonse.checkoutsystem.mod.sbo.controller;

import com.github.tivonse.checkoutsystem.mod.sbo.controller.generic.EntityController;
import com.github.tivonse.checkoutsystem.mod.sbo.model.Product;
import com.github.tivonse.checkoutsystem.mod.sbo.service.ProductService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.UnavailableException;
import java.util.UUID;

@RestController
public class ProductController extends EntityController<Product> {

    @Autowired
    private ProductService productService;

    @PostMapping(value = "/products")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        return new ResponseEntity<>(productService.save(product), HttpStatus.CREATED);
    }

    @PutMapping(value = "/products")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) throws NotFoundException {
        return new ResponseEntity<>(productService.updateById(product), HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = "/products/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable String id) {
        productService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
