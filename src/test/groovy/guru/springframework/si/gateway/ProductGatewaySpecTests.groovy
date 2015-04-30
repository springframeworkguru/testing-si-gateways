package guru.springframework.si.gateway

import guru.springframework.si.gateways.ProductGateway
import guru.springframework.si.model.Product
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@ContextConfiguration(locations = "classpath*:/spring/si-test-config.xml")
class ProductGatewaySpecTests extends Specification{

    @Autowired
    ProductGateway productGateway

    def "Test get product gateway"() {
        given:
        def productId = '122222'

        when:
        Product product = productGateway.getProduct('122222')

        println product?.productId
        println product?.description

        then:
        product
        product.productId == productId
    }
}
