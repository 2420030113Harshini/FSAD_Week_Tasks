package com.klu.service;

import com.klu.entity.Product;
import com.klu.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repo;

    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    public Product getProductById(Long id) {
        return repo.findById(id).orElseThrow();
    }

    public Product saveProduct(Product product) {
        return repo.save(product);
    }

    public Product updateProduct(Long id, Product newProduct) {
        Product p = repo.findById(id).orElseThrow();
        p.setName(newProduct.getName());
        p.setDescription(newProduct.getDescription());
        p.setPrice(newProduct.getPrice());
        p.setQuantity(newProduct.getQuantity());
        return repo.save(p);
    }

    public void deleteProduct(Long id) {
        repo.deleteById(id);
    }
}
