package guru.springframework.si.services;

import guru.springframework.si.model.commands.PlaceOrderCommand;
import org.springframework.validation.Errors;

public interface OrderService {
    PlaceOrderCommand placeOrder(PlaceOrderCommand command);

    Errors validateOrder(PlaceOrderCommand command);
}
