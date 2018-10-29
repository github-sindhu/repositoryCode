package com.epam.engx.cleancode.errorhandling.task1;

import com.epam.engx.cleancode.errorhandling.task1.persistence.thirdpartyjar.QueryAdressesException;
import com.epam.engx.cleancode.errorhandling.task1.persistence.thirdpartyjar.UserOrderAdressQueryException;
import com.epam.engx.cleancode.errorhandling.task1.thirdpartyjar.Address;

import java.sql.SQLException;
import java.util.List;

public interface OrderDao {

    List<Address> getOrderAddresses(String userId) throws QueryAdressesException;
}
