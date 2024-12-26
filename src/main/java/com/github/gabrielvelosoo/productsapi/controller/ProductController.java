package com.github.gabrielvelosoo.productsapi.controller;

import com.github.gabrielvelosoo.productsapi.model.Product;
import com.github.gabrielvelosoo.productsapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @PostMapping
    public Product insert(@RequestBody Product product) {
        var id = UUID.randomUUID().toString();
        product.setId(id);
        productRepository.save(product);
        return product;
    }

    @GetMapping(value = "/{id}")
    public Product findById(@PathVariable String id) {
        return productRepository.findById(id).orElse(null);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable String id) {
        productRepository.deleteById(id);
    }

    @PutMapping(value = "/{id}")
    public Product update(@PathVariable String id, @RequestBody Product product) {
        product.setId(id);
        productRepository.save(product);
        return product;
    }

    @GetMapping
    public List<Product> search(@RequestParam String name) {
        return productRepository.findByName(name);
    }
}
