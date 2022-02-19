package com.tgilonis.OrderService.command.command;

public class CreateOrderCommand extends BaseCommand<String>
{
    private final String productId;
    private final String userId;
    private final String addressId;
    private final Integer quantity;
    private final String orderStatus;

    public CreateOrderCommand(CreateOrderCommandBuilder createOrderCommandBuilder)
    {
        super(createOrderCommandBuilder.id);
        this.productId = createOrderCommandBuilder.productId;
        this.userId = createOrderCommandBuilder.userId;
        this.addressId = createOrderCommandBuilder.addressId;
        this.quantity = createOrderCommandBuilder.quantity;
        this.orderStatus = createOrderCommandBuilder.orderStatus;

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

    public static class CreateOrderCommandBuilder
    {
        private final String id;
        private String productId;
        private String userId;
        private String addressId;
        private Integer quantity;
        private String orderStatus;

        public CreateOrderCommandBuilder(String id)
        {
            this.id = id;
        }

        public CreateOrderCommandBuilder productId(String productId)
        {
            this.productId = productId;
            return this;
        }

        public CreateOrderCommandBuilder orderStats(String orderStatus)
        {
            this.orderStatus = orderStatus;
            return this;
        }

        public CreateOrderCommandBuilder userId(String userId)
        {
            this.userId = userId;
            return this;
        }

        public CreateOrderCommandBuilder addressId(String addressId)
        {
            this.addressId = addressId;
            return this;
        }

        public CreateOrderCommandBuilder quantity(Integer quantity)
        {
            this.quantity = quantity;
            return this;
        }

        public CreateOrderCommand build()
        {
            return new CreateOrderCommand(this);
        }
    }
}
