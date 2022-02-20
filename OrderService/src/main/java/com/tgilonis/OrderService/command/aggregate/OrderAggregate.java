package com.tgilonis.OrderService.command.aggregate;

import com.tgilonis.OrderService.command.command.CreateOrderCommand;
import com.tgilonis.OrderService.command.event.OrderCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
public class OrderAggregate
{
    @AggregateIdentifier
    private String id;
    private String productId;
    private String userId;
    private String addressId;
    private Integer quantity;
    private String orderStatus;

    public OrderAggregate()
    {
    }

    @CommandHandler
    public OrderAggregate(CreateOrderCommand createOrderCommand)
    {
        AggregateLifecycle.apply(new OrderCreatedEvent.OrderCreatedEventBuilder(
                createOrderCommand.getOrderId())
                    .productId(createOrderCommand.getProductId())
                    .addressId(createOrderCommand.getAddressId())
                    .orderStatus(createOrderCommand.getOrderStatus())
                    .userId(createOrderCommand.getUserId())
                    .quantity(createOrderCommand.getQuantity())
                    .build()
        );
    }

    @EventSourcingHandler
    public void on(OrderCreatedEvent orderCreatedEvent)
    {
        this.id = orderCreatedEvent.getId();
        this.productId = orderCreatedEvent.getProductId();
        this.addressId = orderCreatedEvent.getAddressId();
        this.userId = orderCreatedEvent.getUserId();
        this.quantity = orderCreatedEvent.getQuantity();
        this.orderStatus =  orderCreatedEvent.getOrderStatus();
    }
}
