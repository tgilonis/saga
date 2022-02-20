package com.tgilonis.OrderService.command.controller;

import com.tgilonis.OrderService.command.command.CreateOrderCommand;
import com.tgilonis.OrderService.command.model.OrderRestModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/orders")
public class OrderCommandController
{

    private CommandGateway commandGateway;

    public OrderCommandController(CommandGateway commandGateway)
    {
        this.commandGateway = commandGateway;
    }

    @PostMapping()
    public String createOrder(@RequestBody OrderRestModel orderRestModel)
    {
        String orderId = UUID.randomUUID().toString();

        CreateOrderCommand createOrderCommand = new CreateOrderCommand.CreateOrderCommandBuilder(orderId)
                .addressId(orderRestModel.getAddressId())
                .productId(orderRestModel.getProductId())
                .quantity(orderRestModel.getQuantity())
                .orderStatus("CREATED")
                .build();

        commandGateway.sendAndWait(createOrderCommand);

        return "Order Created";
    }
}
