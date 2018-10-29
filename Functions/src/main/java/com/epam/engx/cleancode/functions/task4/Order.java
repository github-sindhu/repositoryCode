package com.epam.engx.cleancode.functions.task4;

import com.epam.engx.cleancode.functions.task4.thirdpartyjar.Product;

import java.util.Iterator;
import java.util.List;

public class Order {

    private List<Product> products;

    public Double getPriceOfAvailableProducts() {

        RemoveTheProductsNotAvailable();
       return  getPriceOfProducts();


    }

    public void RemoveTheProductsNotAvailable()

    {
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product p = iterator.next();
            if (p.isNotAvailable())
                iterator.remove();
        }

    }

    public Double getPriceOfProducts()
    {
        double orderPrice = 0.0;
        for (Product p : products)
            orderPrice += p.getProductPrice();
        return orderPrice;

    }






    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
