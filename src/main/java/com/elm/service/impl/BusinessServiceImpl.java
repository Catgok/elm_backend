package com.elm.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.elm.dao.BusinessDao;
import com.elm.dao.impl.BusinessDaoImpl;
import com.elm.po.Business;
import com.elm.service.BusinessService;
import com.elm.util.DBUtil;

public class BusinessServiceImpl implements BusinessService {
    @Override
    public List<Business> listBusinessByOrderTypeId(Integer orderTypeId) {
        List<Business> list = new ArrayList<>();
        BusinessDao dao = new BusinessDaoImpl();
        try {
            DBUtil.getConnection();
            list = dao.listBusinessByOrderTypeId(orderTypeId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close();
        }
        return list;
    }

    @Override
    public Business getBusinessById(Integer businessId) {
        Business business = null;
        BusinessDao dao = new BusinessDaoImpl();
        try {
            DBUtil.getConnection();
            business = dao.getBusinessById(businessId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close();
        }
        return business;
    }
}