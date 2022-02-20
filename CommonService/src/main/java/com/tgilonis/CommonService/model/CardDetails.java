package com.tgilonis.CommonService.model;

import org.springframework.beans.BeanUtils;

public class CardDetails
{
    private String name;
    private String cardNumber;
    private Integer validUntilMonth;
    private Integer validUntilYear;
    private Integer cvv;

    public CardDetails()
    {
    }

    @Override
    public String toString()
    {
        return "CardDetails{" +
                "name='" + name + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", validUntilMonth=" + validUntilMonth +
                ", validUntilYear=" + validUntilYear +
                ", cvv=" + cvv +
                '}';
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getCardNumber()
    {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber)
    {
        this.cardNumber = cardNumber;
    }

    public Integer getValidUntilMonth()
    {
        return validUntilMonth;
    }

    public void setValidUntilMonth(Integer validUntilMonth)
    {
        this.validUntilMonth = validUntilMonth;
    }

    public Integer getValidUntilYear()
    {
        return validUntilYear;
    }

    public void setValidUntilYear(Integer validUntilYear)
    {
        this.validUntilYear = validUntilYear;
    }

    public Integer getCvv()
    {
        return cvv;
    }

    public void setCvv(Integer cvv)
    {
        this.cvv = cvv;
    }

    public static class CardDetailsBuilder
    {
        private String name;
        private String cardNumber;
        private Integer validUntilMonth;
        private Integer validUntilYear;
        private Integer cvv;

        public CardDetailsBuilder()
        {
        }

        public CardDetailsBuilder name(String name)
        {
            this.name = name;
            return this;
        }

        public CardDetailsBuilder cardNumber(String cardNumber)
        {
            this.cardNumber = cardNumber;
            return this;
        }

        public CardDetailsBuilder validUntilMonth(Integer validUntilMonth)
        {
            this.validUntilMonth = validUntilMonth;
            return this;
        }

        public CardDetailsBuilder validUntilYear(Integer validUntilYear)
        {
            this.validUntilYear = validUntilYear;
            return this;
        }

        public CardDetailsBuilder cvv(Integer cvv)
        {
            this.cvv = cvv;
            return this;
        }

        public CardDetails build()
        {
            CardDetails cardDetails = new CardDetails();
            BeanUtils.copyProperties(this, cardDetails);
            return cardDetails;
        }
    }
}
