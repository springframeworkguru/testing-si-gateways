package guru.springframework.si;

import guru.springframework.si.gateways.ProductGateway;
import guru.springframework.si.model.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath*:/spring/si-config.xml")
public class TestingSiGatewaysApplication {

    public static void main(String[] args) {
        ApplicationContext ctx =  SpringApplication.run(TestingSiGatewaysApplication.class, args);
        ProductGateway productGateway = (ProductGateway) ctx.getBean("productGateway");
        Product product = productGateway.getProduct("1234");

        System.out.println(product.getProductId());
        System.out.println(product.getDescription());
    }
}
