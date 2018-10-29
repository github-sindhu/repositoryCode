package com.epam.engx.cleancode.errorhandling.task1.persistence.thirdpartyjar;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface SqlService {

    Map queryUserHomeAddress(String userId) throws UserHomeAdressQueryException;

    List<Map> queryUserDeliveryAddress(String userId) throws UserDeliveryAdressQueryException;

    List<Map> queryUserOrderAddress(String userId) throws UserOrderAdressQueryException;
}
