package com.elm.service.impl;
import java.util.ArrayList;
import java.util.List;
import com.elm.dao.BusinessDao;
import com.elm.dao.FoodDao;
import com.elm.dao.impl.BusinessDaoImpl;
import com.elm.dao.impl.FoodDaoImpl;
import com.elm.po.Business;
import com.elm.po.Food;
import com.elm.service.FoodService;
import com.elm.util.DBUtil;
public class FoodServiceImpl implements FoodService{
    @Override
    public List<Food> listFoodByBusinessId(Integer businessId) {
        List<Food> list = new ArrayList<>();
        FoodDao dao = new FoodDaoImpl();
        try {
            DBUtil.getConnection();
            list = dao.listFoodByBusinessId(businessId);
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtil.close();
        }
        return list;
    }
}