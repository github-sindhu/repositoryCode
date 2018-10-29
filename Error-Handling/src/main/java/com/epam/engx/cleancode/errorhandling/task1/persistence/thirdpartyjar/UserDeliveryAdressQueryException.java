package com.epam.engx.cleancode.errorhandling.task1.persistence.thirdpartyjar;



public class UserDeliveryAdressQueryException extends QueryAdressesException{

    public UserDeliveryAdressQueryException()
    {
             super("This exception caused during Delivery Adress query");
    }

}
