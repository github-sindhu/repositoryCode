package com.epam.engx.cleancode.errorhandling.task1.persistence.thirdpartyjar;

public class UserOrderAdressQueryException extends QueryAdressesException {
    public UserOrderAdressQueryException()
    {
        super("This exception caused during Order Adress query");
    }

}
