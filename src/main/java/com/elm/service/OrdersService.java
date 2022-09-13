package com.elm.service;
import java.util.List;
import com.elm.po.Orders;
public interface OrdersService {
    public int createOrders(String userId,Integer businessId,Integer daId,Double orderTotal);
    public Orders getOrdersById(Integer orderId);
    public List<Orders> listOrdersByUserId(String userId);
}