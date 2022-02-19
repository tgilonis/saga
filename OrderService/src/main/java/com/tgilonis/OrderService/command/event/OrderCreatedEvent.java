package com.tgilonis.OrderService.command.event;

public class OrderCreatedEvent extends BaseEvent<String>
{
    private String id;
    private String productId;
    private String userId;
    private String addressId;
    private Integer quantity;
    private String orderStatus;

    public OrderCreatedEvent(OrderCreatedEventBuilder orderCreatedEventBuilder)
    {
        super(orderCreatedEventBuilder.id);
        this.productId = orderCreatedEventBuilder.productId;
        this.userId = orderCreatedEventBuilder.userId;
        this.addressId = orderCreatedEventBuilder.addressId;
        this.quantity = orderCreatedEventBuilder.quantity;
        this.orderStatus = orderCreatedEventBuilder.orderStatus;

    }

    public String getProductId()
    {
        return productId;
    }

    public String getUserId()
    {
        return userId;
    }

    public String getAddressId()
    {
        return addressId;
    }

    public Integer getQuantity()
    {
        return quantity;
    }

    public String getOrderStatus()
    {
        return orderStatus;
    }

    public static class OrderCreatedEventBuilder
    {
        private final String id;
        private String productId;
        private String userId;
        private String addressId;
        private Integer quantity;
        private String orderStatus;

        public OrderCreatedEventBuilder(String id)
        {
            this.id = id;
        }

        public OrderCreatedEventBuilder productId(String productId)
        {
            this.productId = productId;
            return this;
        }

        public OrderCreatedEventBuilder orderStatus(String orderStatus)
        {
            this.orderStatus = orderStatus;
            return this;
        }

        public OrderCreatedEventBuilder userId(String userId)
        {
            this.userId = userId;
            return this;
        }

        public OrderCreatedEventBuilder addressId(String addressId)
        {
            this.addressId = addressId;
            return this;
        }

        public OrderCreatedEventBuilder quantity(Integer quantity)
        {
            this.quantity = quantity;
            return this;
        }

        public OrderCreatedEvent build()
        {
            return new OrderCreatedEvent(this);
        }
    }


}
