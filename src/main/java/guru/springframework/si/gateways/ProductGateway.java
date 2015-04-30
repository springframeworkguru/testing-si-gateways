package guru.springframework.si.gateways;

import guru.springframework.si.model.Product;
import org.springframework.integration.annotation.Gateway;

public interface ProductGateway {

    @Gateway(requestChannel = "getProductChannel")
    Product getProduct(String productId);
}
