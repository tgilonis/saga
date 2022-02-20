package com.tgilonis.CommonService.events;


public class PaymentProcessedEvent
{
    private String paymentId;
    private String orderId;

    public PaymentProcessedEvent(String paymentId, String orderId)
    {
        this.paymentId = paymentId;
        this.orderId = orderId;
    }

    public PaymentProcessedEvent()
    {
    }

    @Override
    public String toString()
    {
        return "PaymentProcessedEvent{" +
                "paymentId='" + paymentId + '\'' +
                ", orderId='" + orderId + '\'' +
                '}';
    }

    public String getPaymentId()
    {
        return paymentId;
    }

    public void setPaymentId(String paymentId)
    {
        this.paymentId = paymentId;
    }

    public String getOrderId()
    {
        return orderId;
    }

    public void setOrderId(String orderId)
    {
        this.orderId = orderId;
    }
}
