package com.epam.engx.cleancode.errorhandling.task1.persistence.thirdpartyjar;

public class UserHomeAdressQueryException extends QueryAdressesException  {
    public UserHomeAdressQueryException()
    {
        super("This exception caused during Home Adress query");
    }

}
