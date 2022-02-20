package com.tgilonis.UserService.projection;

import com.tgilonis.CommonService.model.CardDetails;
import com.tgilonis.CommonService.model.User;
import com.tgilonis.CommonService.queries.GetUserPaymentDetailsQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

@Component
public class UserProjection
{
    @QueryHandler
    public User getUserPaymentDetails(GetUserPaymentDetailsQuery getUserPaymentDetailsQuery)
    {
        // Ideally - get the details from the DB. Here we are using static info for expedience
        CardDetails cardDetails = new CardDetails.CardDetailsBuilder()
                .name("Theo Gilonis")
                .validUntilMonth(01)
                .validUntilYear(2022)
                .cardNumber("0123456789")
                .cvv(111)
                .build();

        return new User.UserBuilder()
                .userId(getUserPaymentDetailsQuery.getUserId())
                .firstName("Theo")
                .lastName("Gilonis")
                .cardDetails(cardDetails)
                .build();
    }

}
