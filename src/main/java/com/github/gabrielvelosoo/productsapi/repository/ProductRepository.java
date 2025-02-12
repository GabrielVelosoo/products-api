package com.github.gabrielvelosoo.productsapi.repository;

import com.github.gabrielvelosoo.productsapi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, String> {

    List<Product> findByName(String name);
}
