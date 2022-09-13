package com.elm.controller;
import java.util.List;
import jakarta.servlet.http.HttpServletRequest;
import com.elm.po.Food;
import com.elm.service.FoodService;
import com.elm.service.impl.FoodServiceImpl;
public class FoodController {
    public Object listFoodByBusinessId(HttpServletRequest request) throws Exception{
        Integer businessId = Integer.valueOf(request.getParameter("businessId"));
        FoodService service = new FoodServiceImpl();
        List<Food> list = service.listFoodByBusinessId(businessId);
        return list;
    }
}