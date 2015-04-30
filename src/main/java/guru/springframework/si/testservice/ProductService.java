package guru.springframework.si.testservice;

import guru.springframework.si.model.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    public Product getProduct(String productId) {
        Product product = new Product();
        product.setProductId(productId);
        product.setDescription("Product from Production");

        return product;
    }
}
