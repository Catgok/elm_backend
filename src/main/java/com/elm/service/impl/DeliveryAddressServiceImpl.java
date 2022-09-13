package com.elm.service.impl;
import java.util.ArrayList;
import java.util.List;
import com.elm.dao.DeliveryAddressDao;
import com.elm.dao.impl.DeliveryAddressDaoImpl;
import com.elm.po.DeliveryAddress;
import com.elm.service.DeliveryAddressService;
import com.elm.util.DBUtil;
public class DeliveryAddressServiceImpl implements DeliveryAddressService{
    @Override
    public List<DeliveryAddress> listDeliveryAddressByUserId(String userId) {
        List<DeliveryAddress> list = new ArrayList<>();
        DeliveryAddressDao dao = new DeliveryAddressDaoImpl();
        try {
            DBUtil.getConnection();
            list = dao.listDeliveryAddressByUserId(userId);
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtil.close();
        }
        return list;
    }
    @Override
    public int saveDeliveryAddress(DeliveryAddress deliveryAddress) {
        int result = 0;
        DeliveryAddressDao dao = new DeliveryAddressDaoImpl();
        try {
            DBUtil.getConnection();
            result = dao.saveDeliveryAddress(deliveryAddress);
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtil.close();
        }
        return result;
    }
    @Override
    public DeliveryAddress getDeliveryAddressById(Integer daId) {
        DeliveryAddress deliveryAddress = null;
        DeliveryAddressDao dao = new DeliveryAddressDaoImpl();
        try {
            DBUtil.getConnection();
            deliveryAddress = dao.getDeliveryAddressById(daId);
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtil.close();
        }
        return deliveryAddress;
    }
    @Override
    public int updateDeliveryAddress(DeliveryAddress deliveryAddress) {
        int result = 0;
        DeliveryAddressDao dao = new DeliveryAddressDaoImpl();
        try {
            DBUtil.getConnection();
            result = dao.updateDeliveryAddress(deliveryAddress);
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtil.close();
        }
        return result;
    }
    @Override
    public int removeDeliveryAddress(Integer daId) {
        int result = 0;
        DeliveryAddressDao dao = new DeliveryAddressDaoImpl();
        try {
            DBUtil.getConnection();
            result = dao.removeDeliveryAddress(daId);
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtil.close();
        }
        return result;
    }
}