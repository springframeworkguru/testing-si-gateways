package guru.springframework.si.services;

import guru.springframework.si.model.Product;
import org.springframework.stereotype.Service;

@Service
public class GatewayTestService {
    private String lastString;

    public Product getProduct(String productId){
        Product product = new Product();
        product.setProductId(productId);
        product.setDescription("Product in TESTING!!");
        return product;
    }

    public String getLastString() {
        return lastString;
    }

    public void setLastString(String lastString) {
        this.lastString = lastString;
    }
}
