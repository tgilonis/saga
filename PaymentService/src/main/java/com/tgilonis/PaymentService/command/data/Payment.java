package com.tgilonis.PaymentService.command.data;

import org.springframework.beans.BeanUtils;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class Payment
{
    private String paymentId;
    private String orderId;
    private Date timeStamp;
    private String paymentStatus;

    public Payment(String paymentId, String orderId, Date timeStamp, String paymentStatus)
    {
        this.paymentId = paymentId;
        this.orderId = orderId;
        this.timeStamp = timeStamp;
        this.paymentStatus = paymentStatus;
    }

    public Payment()
    {
    }

    @Override
    public String toString()
    {
        return "Payment{" +
                "paymentId='" + paymentId + '\'' +
                ", orderId='" + orderId + '\'' +
                ", timeStamp=" + timeStamp +
                ", paymentStatus='" + paymentStatus + '\'' +
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

    public Date getTimeStamp()
    {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp)
    {
        this.timeStamp = timeStamp;
    }

    public String getPaymentStatus()
    {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus)
    {
        this.paymentStatus = paymentStatus;
    }

    public static class PaymentBuilder
    {
        private String paymentId;
        private String orderId;
        private Date timeStamp;
        private String paymentStatus;

        public PaymentBuilder()
        {
        }

        public PaymentBuilder paymentId(String paymentId)
        {
            this.paymentId = paymentId;
            return this;
        }

        public PaymentBuilder orderId(String orderId)
        {
            this.orderId = orderId;
            return this;
        }

        public PaymentBuilder timeStamp(Date timeStamp)
        {
            this.timeStamp = timeStamp;
            return this;
        }

        public PaymentBuilder paymentStatus(String paymentStatus)
        {
            this.paymentStatus = paymentStatus;
            return this;
        }

        public Payment build()
        {
            Payment payment = new Payment();
            BeanUtils.copyProperties(this, payment);
            return payment;
        }
    }
}
