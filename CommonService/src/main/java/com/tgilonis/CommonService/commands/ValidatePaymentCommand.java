package com.tgilonis.CommonService.commands;

import com.tgilonis.CommonService.model.CardDetails;
import org.axonframework.modelling.command.TargetAggregateIdentifier;
import org.springframework.beans.BeanUtils;

public class ValidatePaymentCommand
{
    @TargetAggregateIdentifier
    private String paymentId;
    private String orderId;
    private CardDetails cardDetails;

    @Override
    public String toString()
    {
        return "ValidatePaymentCommand{" +
                "paymentId='" + paymentId + '\'' +
                ", orderId='" + orderId + '\'' +
                ", cardDetails=" + cardDetails +
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

    public CardDetails getCardDetails()
    {
        return cardDetails;
    }

    public void setCardDetails(CardDetails cardDetails)
    {
        this.cardDetails = cardDetails;
    }

    public static class ValidatePaymentCommandBuilder
    {
        private String paymentId;
        private String orderId;
        private CardDetails cardDetails;

        public ValidatePaymentCommandBuilder()
        {
        }

        public ValidatePaymentCommandBuilder paymentId(String paymentId)
        {
            this.paymentId = paymentId;
            return this;
        }

        public ValidatePaymentCommandBuilder orderId(String orderId)
        {
            this.orderId = orderId;
            return this;
        }

        public ValidatePaymentCommandBuilder cardDetails(CardDetails cardDetails)
        {
            this.cardDetails = cardDetails;
            return this;
        }

        public ValidatePaymentCommand build()
        {
            ValidatePaymentCommand validatePaymentCommand = new ValidatePaymentCommand();
            BeanUtils.copyProperties(this, validatePaymentCommand);
            return validatePaymentCommand;
        }
    }
}
