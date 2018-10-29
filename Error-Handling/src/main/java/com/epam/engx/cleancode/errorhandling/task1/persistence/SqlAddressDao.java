package com.epam.engx.cleancode.errorhandling.task1.persistence;

import com.epam.engx.cleancode.errorhandling.task1.persistence.thirdpartyjar.QueryAdressesException;
import com.epam.engx.cleancode.errorhandling.task1.persistence.thirdpartyjar.UserHomeAdressQueryException;
import com.epam.engx.cleancode.errorhandling.task1.thirdpartyjar.Address;
import com.epam.engx.cleancode.errorhandling.task1.AddressDao;
import com.epam.engx.cleancode.errorhandling.task1.persistence.thirdpartyjar.SqlService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SqlAddressDao implements AddressDao {

    SqlService sqlService;

    public Address getHomeAddress(String userId) throws QueryAdressesException {
        return new Address(sqlService.queryUserHomeAddress(userId));
    }

    public List<Address> getDeliveryAddresses(String userId) throws QueryAdressesException {
        List<Address> addresses = new ArrayList<Address>();
        for (Map addressData : sqlService.queryUserDeliveryAddress(userId))
            addresses.add(new Address(addressData));
        return addresses;
    }
}
