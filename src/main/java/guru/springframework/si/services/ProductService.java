package guru.springframework.si.services;

import guru.springframework.si.model.Product;

public interface ProductService {
    Product getProduct(String productId);
}
