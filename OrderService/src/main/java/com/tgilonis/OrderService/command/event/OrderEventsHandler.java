package com.tgilonis.OrderService.command.event;

import com.tgilonis.OrderService.command.data.Order;
import com.tgilonis.OrderService.command.data.OrderRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class OrderEventsHandler
{
    private OrderRepository orderRepository;

    public OrderEventsHandler(OrderRepository orderRepository)
    {
        this.orderRepository = orderRepository;
    }

    @EventHandler
    public void on(OrderCreatedEvent orderCreatedEvent)
    {
        Order order = new Order();
        BeanUtils.copyProperties(orderCreatedEvent, order);
        orderRepository.save(order);
    }
}
