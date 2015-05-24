package guru.springframework.si.gateways;

import guru.springframework.si.model.commands.PlaceOrderCommand;
import org.springframework.integration.annotation.Gateway;
import org.springframework.validation.Errors;

import java.util.concurrent.Future;

public interface InventoryGateway {
    @Gateway(requestChannel = "verifyOrderInventoryChannel")
    Future<Errors> verifyOrderInventory(PlaceOrderCommand command);
}
