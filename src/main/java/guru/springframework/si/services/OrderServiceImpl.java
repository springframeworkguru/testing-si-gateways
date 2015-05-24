package guru.springframework.si.services;

import guru.springframework.si.gateways.AddressGateway;
import guru.springframework.si.gateways.InventoryGateway;
import guru.springframework.si.gateways.OrderGateway;
import guru.springframework.si.gateways.PaymentGateway;
import guru.springframework.si.model.commands.PlaceOrderCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

    private AddressGateway addressGateway;
    private InventoryGateway inventoryGateway;
    private OrderGateway orderGateway;
    private PaymentGateway paymentGateway;

    @Autowired
    public void setAddressGateway(AddressGateway addressGateway) {
        this.addressGateway = addressGateway;
    }

    @Autowired
    public void setInventoryGateway(InventoryGateway inventoryGateway) {
        this.inventoryGateway = inventoryGateway;
    }

    @Autowired
    public void setOrderGateway(OrderGateway orderGateway) {
        this.orderGateway = orderGateway;
    }

    @Autowired
    public void setPaymentGateway(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    @Override
    public PlaceOrderCommand placeOrder(PlaceOrderCommand command) {
        Future<Errors> validateOrderErrorsFuture = orderGateway.validateOrder(command);
        Future<Errors> validateAddressErrorsFuture = addressGateway.verifyAddress(command);
        Future<Errors> validateInventoryErrorsFuture = inventoryGateway.verifyOrderInventory(command);
        Future<Errors> verifyCreditCardErrorsFuture = paymentGateway.verifyCreditCard(command);

        try {
            Errors validateOrderErrors = validateOrderErrorsFuture.get();
            Errors validateAddressErrors = validateAddressErrorsFuture.get();
            Errors validateInventoryErrors = validateInventoryErrorsFuture.get();
            Errors verifyCreditCardErrors = verifyCreditCardErrorsFuture.get();

            if (!validateOrderErrors.hasErrors() &&
                    !validateAddressErrors.hasErrors() &&
                    !validateInventoryErrors.hasErrors() &&
                    !verifyCreditCardErrors.hasErrors()) {
                return command;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return command;
    }

    @Override
    public Errors validateOrder(PlaceOrderCommand command) {
        System.out.println("Validating Order.....");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Validating Order - DONE");
        Errors errors = new BeanPropertyBindingResult(command, "Place Order Command");
        return errors;
    }
}
