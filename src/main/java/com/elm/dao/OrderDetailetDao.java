package com.elm.dao;

import java.util.List;

import com.elm.po.OrderDetailet;

public interface OrderDetailetDao {
    public int saveOrderDetailetBatch(List<OrderDetailet> list) throws Exception;

    public List<OrderDetailet> listOrderDetailetByOrderId(Integer orderId) throws Exception;
}