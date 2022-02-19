package com.tgilonis.OrderService.command.controller;

import com.tgilonis.OrderService.command.model.OrderRestModel;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderCommandController
{
    @PostMapping()
    public String createOrder(@RequestBody OrderRestModel orderRestModel)
    {
        return "Order Created";
    }
}
