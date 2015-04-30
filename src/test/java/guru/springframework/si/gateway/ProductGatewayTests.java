package guru.springframework.si.gateway;

import guru.springframework.si.gateways.ProductGateway;
import guru.springframework.si.model.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:/spring/si-test-config.xml")
public class ProductGatewayTests {

    @Autowired
    ProductGateway productGateway;

    @Test
    public void testGetProduct(){
        Product product = productGateway.getProduct("33333");

        assertNotNull(product);
        assertEquals("33333", product.getProductId());

        System.out.println(product.getProductId());
        System.out.println(product.getDescription());
    }
}
