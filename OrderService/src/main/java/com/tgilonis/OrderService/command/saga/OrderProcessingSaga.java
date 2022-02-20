package com.tgilonis.OrderService.command.saga;

import com.tgilonis.CommonService.commands.ValidatePaymentCommand;
import com.tgilonis.CommonService.events.PaymentProcessedEvent;
import com.tgilonis.CommonService.model.User;
import com.tgilonis.CommonService.queries.GetUserPaymentDetailsQuery;
import com.tgilonis.OrderService.command.event.OrderCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.modelling.saga.SagaEventHandler;
import org.axonframework.modelling.saga.StartSaga;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.spring.stereotype.Saga;

import java.util.UUID;

@Saga
@Slf4j
public class OrderProcessingSaga
{

    private CommandGateway commandGateway;
    private QueryGateway queryGateway;

    public OrderProcessingSaga(CommandGateway commandGateway, QueryGateway queryGateway)
    {
        this.commandGateway = commandGateway;
        this.queryGateway = queryGateway;
    }

    @StartSaga
    @SagaEventHandler(associationProperty = "orderId")
    private void handle(OrderCreatedEvent orderCreatedEvent)
    {
        log.info("OrderCreatedEvent in Saga for order ID: {}", orderCreatedEvent.getId());

        GetUserPaymentDetailsQuery getUserPaymentDetailsQuery
                = new GetUserPaymentDetailsQuery(orderCreatedEvent.getUserId());

        User user = null;

        try
        {
            user = queryGateway.query(
                    getUserPaymentDetailsQuery,
                    ResponseTypes.instanceOf(User.class)
            ).join();
        }
        catch (Exception e)
        {
            log.error(e.getMessage());
            // Due to error, start the Compensating transaction - in this example, it is to cancel the order
        }


        ValidatePaymentCommand validatePaymentCommand = new ValidatePaymentCommand.ValidatePaymentCommandBuilder()
                .cardDetails(user.getCardDetails())
                .orderId(orderCreatedEvent.getId())
                .paymentId(UUID.randomUUID().toString())
                .build();

        commandGateway.sendAndWait(validatePaymentCommand);
    }

    @SagaEventHandler(associationProperty = "orderId")
    private void handle(PaymentProcessedEvent paymentProcessedEvent)
    {
        
    }
}
