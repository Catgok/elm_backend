package com.elm.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.elm.dao.FoodDao;
import com.elm.po.Business;
import com.elm.po.Food;
import com.elm.util.DBUtil;

public class FoodDaoImpl implements FoodDao {
    private Connection con = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;

    @Override
    public List<Food> listFoodByBusinessId(Integer businessId) throws Exception {
        List<Food> list = new ArrayList<>();
        String sql = "select * from food where businessId=? order by foodId";
        try {
            con = DBUtil.getConnection();
            pst = con.prepareStatement(sql);
            pst.setInt(1, businessId);
            rs = pst.executeQuery();
            while (rs.next()) {
                Food food = new Food();
                food.setFoodId(rs.getInt("foodId"));
                food.setFoodName(rs.getString("foodName"));
                food.setFoodExplain(rs.getString("foodExplain"));
                food.setFoodImg(rs.getString("foodImg"));
                food.setFoodPrice(rs.getDouble("foodPrice"));
                food.setBusinessId(rs.getInt("businessId"));
                food.setRemarks(rs.getString("remarks"));
                list.add(food);
            }
        } finally {
            DBUtil.close(rs, pst);
        }
        return list;
    }
}