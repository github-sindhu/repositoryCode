package com.epam.engx.cleancode.errorhandling.task1;

import com.epam.engx.cleancode.errorhandling.task1.persistence.thirdpartyjar.QueryAdressesException;
import com.epam.engx.cleancode.errorhandling.task1.persistence.thirdpartyjar.UserDeliveryAdressQueryException;
import com.epam.engx.cleancode.errorhandling.task1.persistence.thirdpartyjar.UserHomeAdressQueryException;
import com.epam.engx.cleancode.errorhandling.task1.thirdpartyjar.Address;

import java.sql.SQLException;
import java.util.List;

public interface AddressDao {

    Address getHomeAddress(String userId) throws QueryAdressesException;

    List<Address> getDeliveryAddresses(String userId) throws QueryAdressesException;

}
