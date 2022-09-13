package com.elm.controller;

import java.util.List;

import com.elm.po.Business;
import com.elm.service.BusinessService;
import com.elm.service.impl.BusinessServiceImpl;
import jakarta.servlet.http.HttpServletRequest;

public class BusinessController {
    public Object listBusinessByOrderTypeId(HttpServletRequest request) throws Exception {
        Integer orderTypeId = Integer.valueOf(request.getParameter("orderTypeId"));
        BusinessService service = new BusinessServiceImpl();
        List<Business> list = service.listBusinessByOrderTypeId(orderTypeId);
        return list;
    }

    public Object getBusinessById(HttpServletRequest request) throws Exception {
        Integer businessId = Integer.valueOf(request.getParameter("businessId"));
        BusinessService service = new BusinessServiceImpl();
        Business business = service.getBusinessById(businessId);
        return business;
    }
}