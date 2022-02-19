package com.tgilonis.OrderService.command.aggregate;

import com.tgilonis.OrderService.command.command.CreateOrderCommand;
import com.tgilonis.OrderService.command.event.OrderCreatedEvent;
import org.axonframework.test.aggregate.AggregateTestFixture;
import org.axonframework.test.aggregate.FixtureConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrderAggregateTest
{
    private FixtureConfiguration<OrderAggregate> fixture;

    @BeforeEach
    void setUp()
    {
        fixture = new AggregateTestFixture<>(OrderAggregate.class);
    }

    @Test
    void onCreateOrderCommand()
    {
        fixture.givenNoPriorActivity()
                .when(new CreateOrderCommand.CreateOrderCommandBuilder("id")
                        .productId("chair")
                        .build()
                )
                .expectSuccessfulHandlerExecution()
                .expectEvents(
                        new OrderCreatedEvent.OrderCreatedEventBuilder("id")
                                .productId("chair")
                                .build()
                );
    }
}