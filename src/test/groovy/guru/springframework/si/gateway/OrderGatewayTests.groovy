package guru.springframework.si.gateway

import guru.springframework.si.gateways.OrderGateway
import guru.springframework.si.model.commands.PlaceOrderCommand
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@ContextConfiguration(locations = "classpath*:/spring/si-config.xml")
class OrderGatewayTests extends Specification {

    @Autowired
    OrderGateway orderGateway

    def "Test Place Order"() {
        given:
        PlaceOrderCommand command = new PlaceOrderCommand()

        when:
        PlaceOrderCommand result = orderGateway.placeOrder(command)

        then:
        result

    }
}
