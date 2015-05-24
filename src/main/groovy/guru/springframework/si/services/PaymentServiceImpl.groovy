package guru.springframework.si.services

import guru.springframework.si.model.commands.PlaceOrderCommand
import org.springframework.stereotype.Service
import org.springframework.validation.BeanPropertyBindingResult
import org.springframework.validation.Errors


@Service("paymentService")
class PaymentServiceImpl implements PaymentService {
    @Override
    Errors verifyPayment(PlaceOrderCommand command) {

        def i = 0
        def msg = Thread.currentThread().id + ' : In Payment Service'
        while (i < 1000) {
            println msg
            i = i + 100
            msg = msg + '. '
        }
        new BeanPropertyBindingResult(command, 'Place Order Command')
    }
}
