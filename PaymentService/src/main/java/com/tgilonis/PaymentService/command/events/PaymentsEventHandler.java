package com.tgilonis.PaymentService.command.events;

import com.tgilonis.CommonService.events.PaymentProcessedEvent;
import com.tgilonis.PaymentService.command.data.Payment;
import com.tgilonis.PaymentService.command.data.PaymentRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class PaymentsEventHandler
{
    private PaymentRepository paymentRepository;

    public PaymentsEventHandler(PaymentRepository paymentRepository)
    {
        this.paymentRepository = paymentRepository;
    }

    @EventHandler
    public void on(PaymentProcessedEvent paymentProcessedEvent)
    {
        Payment payment = new Payment.PaymentBuilder()
                .paymentId(paymentProcessedEvent.getPaymentId())
                .orderId(paymentProcessedEvent.getOrderId())
                .paymentStatus("COMPLETED")
                .timeStamp(new Date())
                .build();

        paymentRepository.save(payment);
    }
}
