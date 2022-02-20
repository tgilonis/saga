package com.tgilonis.CommonService.model;

import org.springframework.beans.BeanUtils;

public class User
{
    private String userId;
    private String firstName;
    private String lastName;
    private CardDetails cardDetails;

    public String getUserId()
    {
        return userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public CardDetails getCardDetails()
    {
        return cardDetails;
    }

    public void setCardDetails(CardDetails cardDetails)
    {
        this.cardDetails = cardDetails;
    }

    @Override
    public String toString()
    {
        return "User{" +
                "userId='" + userId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", cardDetails='" + cardDetails + '\'' +
                '}';
    }

    public static class UserBuilder
    {
        private String userId;
        private String firstName;
        private String lastName;
        private CardDetails cardDetails;



        public UserBuilder()
        {
        }

        public UserBuilder userId(String userId)
        {
            this.userId = userId;
            return this;
        }

        public UserBuilder firstName(String firstName)
        {
            this.firstName = firstName;
            return this;
        }

        public UserBuilder lastName(String lastName)
        {
            this.lastName = lastName;
            return this;
        }

        public UserBuilder cardDetails(CardDetails cardDetails)
        {
            this.cardDetails = cardDetails;
            return this;
        }

        public User build()
        {
            User user = new User();
            BeanUtils.copyProperties(this, user);
            return user;
        }
    }
}
